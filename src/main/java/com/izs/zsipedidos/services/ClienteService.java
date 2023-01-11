package com.izs.zsipedidos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.izs.zsipedidos.domain.Cliente;
import com.izs.zsipedidos.domain.DTO.ClienteDTO;
import com.izs.zsipedidos.repositories.ClienteRepository;
import com.izs.zsipedidos.services.exeptions.ObjectNotFoundExeption;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo;
	
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
    
    private void updateData(Cliente clienteBD, Cliente cliente) {
    	clienteBD.setNome(cliente.getNome());
    	clienteBD.setEmail(cliente.getEmail());
    }

}
