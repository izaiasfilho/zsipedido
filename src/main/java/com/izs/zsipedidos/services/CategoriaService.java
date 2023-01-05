package com.izs.zsipedidos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.izs.zsipedidos.domain.Categoria;
import com.izs.zsipedidos.repositories.CategoriaRepository;
import com.izs.zsipedidos.services.exeptions.ObjectNotFoundExeption;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		return repo.findById(id)
				.orElseThrow( () -> new ObjectNotFoundExeption("Categoria não encontrada!"
						+ " Id: "+id+", Tipo: "+Categoria.class.getName()));		
	}
	
	public Categoria insert(Categoria categoria) {
		return categoria.getId() == null ? repo.save(categoria): null;
	}

}
