package com.izs.zsipedidos.domain.enums;

public enum TipoCliente {
	
	PESSOAFISICA(1, "pessoa fisica"),
	PESSOAJURIDICA(2, "pessoa juridica");
	
	private int cod;
	private String descricao;
	
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return this.cod;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(TipoCliente tipoCliente : TipoCliente.values()) {
			if(cod.equals(tipoCliente.getCod())) {
				return tipoCliente;
			}
		}
	throw new IllegalArgumentException("Id inválido: "+cod);
	}

}
