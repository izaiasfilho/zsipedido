package com.izs.zsipedidos.domain;
import java.util.Date;

import com.izs.zsipedidos.domain.enums.EstadoPagamento;

import jakarta.persistence.Entity;
import lombok.Data;


@Data
@Entity
public class PagamentoComBoleto extends Pagamento{
	
	private static final long serialVersionUID = 1L;

	private Date dataPagamento;
	private Date dataVencimento;
	
	public PagamentoComBoleto() {}

	public PagamentoComBoleto(Integer id, EstadoPagamento estadoPagamento, Pedido pedido, Date dataPagamento, Date dataVencimento) {
		super(id, estadoPagamento, pedido);
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
	}
	
	
	
}
