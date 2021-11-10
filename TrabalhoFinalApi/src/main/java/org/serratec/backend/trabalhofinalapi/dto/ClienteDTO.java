package org.serratec.backend.trabalhofinalapi.dto;

import javax.persistence.Embedded;

import org.serratec.backend.trabalhofinalapi.domain.Cliente;
import org.serratec.backend.trabalhofinalapi.domain.Endereco;

public class ClienteDTO {
	private Long idCliente;
	
	private String nomeCliente;
	private String cpfCliente;
	private String emailCliente;
	private String cepCliente;
	
	
	
	
	public ClienteDTO() {
		super();
	}


	public ClienteDTO(Long idCliente, String nomeCliente, String cpfCliente, String emailCliente,
			Endereco endereco) {
		super();
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.cpfCliente = cpfCliente;
		this.emailCliente = emailCliente;
		this.cepCliente = cepCliente;
	}


	public ClienteDTO(Cliente cliente) {
		super();
		this.idCliente = cliente.getIdCliente();
		this.nomeCliente = cliente.getNomeCliente();
		this.cpfCliente = cliente.getCpfCliente();
		this.emailCliente = cliente.getEmailCliente();
		this.cepCliente = cliente.getCepCliente();
	}


	public Long getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}



}
