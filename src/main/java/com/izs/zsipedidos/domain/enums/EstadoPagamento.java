package com.izs.zsipedidos.domain.enums;

public enum EstadoPagamento {
	
	PENDENTE(1, "pendente"),
	QUITADO(2, "quitado"),
	CANCELADO(3, "cancelado");
	
	private int cod;
	private String descricao;
	
	private EstadoPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return this.cod;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static EstadoPagamento toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(EstadoPagamento tipoCliente : EstadoPagamento.values()) {
			if(cod.equals(tipoCliente.getCod())) {
				return tipoCliente;
			}
		}
	throw new IllegalArgumentException("Id inválido: "+cod);
	}

}
