package com.izs.zsipedidos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.izs.zsipedidos.domain.Cidade;
import com.izs.zsipedidos.domain.Cliente;
import com.izs.zsipedidos.domain.Endereco;
import com.izs.zsipedidos.domain.DTO.ClienteDTO;
import com.izs.zsipedidos.domain.DTO.ClienteNewDTO;
import com.izs.zsipedidos.domain.enums.TipoCliente;
import com.izs.zsipedidos.repositories.CidadeRepository;
import com.izs.zsipedidos.repositories.ClienteRepository;
import com.izs.zsipedidos.repositories.EnderecoRepository;
import com.izs.zsipedidos.services.exeptions.ObjectNotFoundExeption;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Cliente insert(Cliente cliente) {
		
		cliente = cliente.getId() == null ? repo.save(cliente): null;
	     enderecoRepository.saveAll(cliente.getEnderecos());
		return cliente;
	}
	
	public Cliente find(Integer id) {
		return repo.findById(id)
				.orElseThrow( () -> new ObjectNotFoundExeption("Cliente não encontrada!"
						+ " Id: "+id+", Tipo: "+Cliente.class.getName()));		
	}
	

	public Cliente update(Cliente cliente) {
		Cliente clienteBD = find(cliente.getId());
		updateData(clienteBD,cliente);
		return repo.save(clienteBD);
	}

    public void delete(Integer id) {
    	try {
    	repo.deleteById(find(id).getId());
    	}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir uma cliente que possue produto!");
		}
    }
    
    public List<ClienteDTO> findAll() {
		return repo.findAll()
				.stream()
				.map(ClienteDTO::new)
				.collect(Collectors.toList());	
	}
    
    public Page<ClienteDTO> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
     PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
     return repo.findAll(pageRequest).map(ClienteDTO::new);	
    }
    
    public Cliente fromDTO(ClienteDTO dto) {
    	return new Cliente(dto.getId(), dto.getNome(), dto.getEmail(),null,null);
    }
    
    public Cliente fromDTO(ClienteNewDTO objDto) {
    	Cliente cli = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(), TipoCliente.toEnum(objDto.getTipo()));
    	Cidade cid = cidadeRepository.findById(objDto.getCidadeId()).get();
    	Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(), 
    			objDto.getBairro(), objDto.getCep(), cli, cid);
    	
    	cli.getEnderecos().add(end);
    	cli.getTelefones().add(objDto.getTelefone1());
    	if(objDto.getTelefone2() != null) {
    		cli.getTelefones().add(objDto.getTelefone2());	
    	}
    	if(objDto.getTelefone3() != null) {
    		cli.getTelefones().add(objDto.getTelefone3());	
    	}
    	return cli;
    }
    private void updateData(Cliente clienteBD, Cliente cliente) {
    	clienteBD.setNome(cliente.getNome());
    	clienteBD.setEmail(cliente.getEmail());
    }

    
}
