package com.izs.zsipedidos.domain;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Categoria implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	
	public Categoria() {}

	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	
}
