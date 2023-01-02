package com.izs.zsipedidos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.izs.zsipedidos.domain.Cliente;
import com.izs.zsipedidos.repositories.ClienteRepository;
import com.izs.zsipedidos.services.exeptions.ObjectNotFoundExeption;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		return repo.findById(id)
				.orElseThrow( () -> new ObjectNotFoundExeption("Cliente não encontrada!"
						+ " Id: "+id+", Tipo: "+Cliente.class.getName()));		
	}

}
