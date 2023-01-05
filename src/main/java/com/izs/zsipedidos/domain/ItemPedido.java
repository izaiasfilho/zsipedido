package com.izs.zsipedidos.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Entity
public class ItemPedido implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId 
	private ItemPedidoPk id = new ItemPedidoPk();

	private Double desconto;
	private Integer quantidade;
	private Double preco;
	
	public ItemPedido() {}

	public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
		super();
		this.id.setPedido(pedido);
		this.id.setProduto(produto);
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	@JsonIgnore
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}
	
}
