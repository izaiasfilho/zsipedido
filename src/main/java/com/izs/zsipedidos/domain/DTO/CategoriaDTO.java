package com.izs.zsipedidos.domain.DTO;

import java.io.Serializable;

import com.izs.zsipedidos.domain.Categoria;

import lombok.Data;

@Data
public class CategoriaDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	
	private Integer id;
	private String nome;
	
	public CategoriaDTO (){}
	

	public CategoriaDTO (Categoria categoria){
		this.id = categoria.getId();
		this.nome = categoria.getNome();
	}
}
