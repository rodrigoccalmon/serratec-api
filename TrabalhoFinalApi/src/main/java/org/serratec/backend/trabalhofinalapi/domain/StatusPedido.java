package org.serratec.backend.trabalhofinalapi.domain;

import org.serratec.backend.trabalhofinalapi.exception.EnumValidationException;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum StatusPedido {
	FINALIZADO(1,"Finalizado"), NAO_FINALIZADO(2,"Não Finalizado");

	private Integer codigo;
	private String tipo;
	
	private StatusPedido(Integer codigo, String tipo) {
		this.codigo = codigo;
		this.tipo = tipo;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@JsonCreator
	public static StatusPedido verifica(Integer value) throws EnumValidationException {
		for (StatusPedido sp: values()) {
			if (value.equals(sp.getCodigo())) {
				return sp;
			}
		}
			throw new EnumValidationException("Status Preenchido Incorretamente");
	}
		
}
