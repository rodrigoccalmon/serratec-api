package org.serratec.backend.trabalhofinalapi.dto;



import org.serratec.backend.trabalhofinalapi.domain.Cliente;
import org.serratec.backend.trabalhofinalapi.domain.Endereco;

public class ClienteInserirDTO {
	private String nomeCliente;
	private String cpfCliente;
	private String emailCliente;
	private String cepCliente;

	private Endereco endereco;
	
	
	
	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


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


	public String getCepCliente() {
		return cepCliente;
	}


	public void setCepCliente(String cepCliente) {
		this.cepCliente = cepCliente;
	}


	




	
}
