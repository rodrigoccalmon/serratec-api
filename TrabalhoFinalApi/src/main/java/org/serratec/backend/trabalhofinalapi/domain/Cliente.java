package org.serratec.backend.trabalhofinalapi.domain;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	@ApiModelProperty(value = "Identificador único do cliente", required = true)
	private Long idCliente;

	@NotBlank(message = "Preencha o nome")
	@Size(max = 60)
	@Column(name = "nome_cliente")
	@ApiModelProperty(value = "Nome do cliente", required = true)
	private String nomeCliente;

	@NotBlank(message = "Preencha o cpf")
	@Size(max = 11)
	@CPF(message = "CPF inválido")
	@Column(name = "cpf_cliente")
	@ApiModelProperty(value = "CPF do cliente", required = true)
	private String cpfCliente;

	@NotBlank(message = "Preencha o email")
	@Email(message = "E-mail inválido")
	@Column(name = "email_cliente")
	@ApiModelProperty(value = "E-mail do cliente", required = true)
	private String emailCliente;
	

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idEndereco")
	private Endereco endereco;
	


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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}




	public Cliente(Long idCliente, @NotBlank(message = "Preencha o nome") @Size(max = 60) String nomeCliente,
			@NotBlank(message = "Preencha o cpf") @Size(max = 11) @CPF(message = "CPF inválido") String cpfCliente,
			@NotBlank(message = "Preencha o email") @Email(message = "E-mail inválido") String emailCliente,
			Endereco endereco) {
		super();
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.cpfCliente = cpfCliente;
		this.emailCliente = emailCliente;
		this.endereco = endereco;

	}

	public Cliente() {
		super();
	}


	





}
