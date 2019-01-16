package com.pedido.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1,"Fisica"),
	PESSOAJURIDICA(2,"Juridca");
	
	private Integer cod;
	private String descricao;
	
	private TipoCliente(Integer cod, String descricao) {
		this.cod =cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCliente ToEnum(Integer cod) {
		if (cod == null ) {
			return null;
		}
		for (TipoCliente tipoCliente : TipoCliente.values()) {
			if(cod.equals(tipoCliente.getCod())) {
				return tipoCliente;
			}
		}
		throw new  IllegalArgumentException();
	}
	
}
