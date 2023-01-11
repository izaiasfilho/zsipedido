package com.izs.zsipedidos.domain.DTO;

import java.io.Serializable;

import com.izs.zsipedidos.domain.Cliente;

import lombok.Data;

@Data
public class ClienteDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	
	private Integer id;
	private String nome;
	private String email;
	
	public ClienteDTO (){}
	

	public ClienteDTO (Cliente cliente){
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
	}
}
