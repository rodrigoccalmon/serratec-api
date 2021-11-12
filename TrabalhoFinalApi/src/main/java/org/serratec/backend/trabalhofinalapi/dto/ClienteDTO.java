package org.serratec.backend.trabalhofinalapi.dto;

import org.serratec.backend.trabalhofinalapi.domain.Cliente;

public class ClienteDTO {
	private Long idCliente;
	
	private String nomeCliente;
	private String cpfCliente;
	private String emailCliente;
	private String cep;
	
	
	public ClienteDTO() {
		super();
	}


	public ClienteDTO(Long idCliente, String nomeCliente, String cpfCliente, String emailCliente,
			String cep) {
		super();
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.cpfCliente = cpfCliente;
		this.emailCliente = emailCliente;
		this.cep = cep;
	}


	public ClienteDTO(Cliente cliente) {
		super();
		this.idCliente = cliente.getIdCliente();
		this.nomeCliente = cliente.getNomeCliente();
		this.cpfCliente = cliente.getCpfCliente();
		this.emailCliente = cliente.getEmailCliente();
		this.cep = cliente.getEndereco().getCep();
	
	}
	

	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public Long getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
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


}
