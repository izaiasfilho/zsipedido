package com.izs.zsipedidos.domain;

import com.izs.zsipedidos.domain.enums.EstadoPagamento;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class PagamentoComCartao extends Pagamento{
	
	private static final long serialVersionUID = 1L;

	private Integer numeroDeParcelas;
	
	public PagamentoComCartao() {}

	public PagamentoComCartao(Integer id, EstadoPagamento estadoPagamento, Pedido pedido, Integer numeroDeParcelas) {
		super(id, estadoPagamento, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	

}
