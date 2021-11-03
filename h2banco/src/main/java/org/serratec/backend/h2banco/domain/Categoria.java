package org.serratec.backend.h2banco.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Categoria {
	HATCH,SEDAN,PIACPE,SUV,CONVERSÍVEL,MINIVAM;
	
	@JsonCreator
	public static Categoria verifica (String value) throws EnumValidationException {
		for (Categoria c : values()) {
			if (value.equals(c.name())) {
				return c;
			}
		}
		throw new EnumValidationException("Categoria preenchida incorretamente");
	}
}
