package org.serratec.backend.trabalhofinalapi.dto;

import org.serratec.backend.trabalhofinalapi.domain.Cliente;

public class ClienteInserirDTO {
	private String nomeCliente;
	private String cpfCliente;
	private String emailCliente;
	private String cep;
	
	
	public ClienteInserirDTO() {
		super();
	}


	public String getNomeCliente() {
		return nomeCliente;
	}


	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}


	public String getCpfCliente() {
		return cpfCliente;
	}


	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}


	public String getEmailCliente() {
		return emailCliente;
	}


	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public ClienteInserirDTO(String nomeCliente, String cpfCliente, String emailCliente, String cep) {
		super();
		this.nomeCliente = nomeCliente;
		this.cpfCliente = cpfCliente;
		this.emailCliente = emailCliente;
		this.cep = cep;
	}


	

	
}
