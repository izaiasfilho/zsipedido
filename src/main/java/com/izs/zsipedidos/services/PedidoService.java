package com.izs.zsipedidos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.izs.zsipedidos.domain.Pedido;
import com.izs.zsipedidos.repositories.PedidoRepository;
import com.izs.zsipedidos.services.exeptions.ObjectNotFoundExeption;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		return repo.findById(id)
				.orElseThrow( () -> new ObjectNotFoundExeption("Pedido não encontrada!"
						+ " Id: "+id+", Tipo: "+Pedido.class.getName()));		
	}

}
