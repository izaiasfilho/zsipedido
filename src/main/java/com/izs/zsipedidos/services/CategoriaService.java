package com.izs.zsipedidos.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.izs.zsipedidos.domain.Categoria;
import com.izs.zsipedidos.domain.DTO.CategoriaDTO;
import com.izs.zsipedidos.repositories.CategoriaRepository;
import com.izs.zsipedidos.services.exeptions.ObjectNotFoundExeption;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		return repo.findById(id)
				.orElseThrow( () -> new ObjectNotFoundExeption("Categoria não encontrada!"
						+ " Id: "+id+", Tipo: "+Categoria.class.getName()));		
	}
	
	public Categoria insert(Categoria categoria) {
		return categoria.getId() == null ? repo.save(categoria): null;
	}
	
	public Categoria update(Categoria categoria) {
		find(categoria.getId());
		return repo.save(categoria);
	}

    public void delete(Integer id) {
    	try {
    	repo.deleteById(find(id).getId());
    	}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir uma categoria que possue produto!");
		}
    }
    
    public List<CategoriaDTO> findAll() {
		return repo.findAll()
				.stream()
				.map(CategoriaDTO::new)
				.collect(Collectors.toList());	
	}
}
