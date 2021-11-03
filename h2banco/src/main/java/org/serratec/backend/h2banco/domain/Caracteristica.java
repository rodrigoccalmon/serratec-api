package org.serratec.backend.h2banco.domain;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Caracteristica {
	private String renavam;
	private String chassi;
	private Long ano;
	
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	private String cor;
	
	@Enumerated(EnumType.ORDINAL)
	private Combustivel combustivel;

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	
}
