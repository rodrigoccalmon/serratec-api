package org.serratec.java2backend.exercicio03.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long id;
	
	@Column(name = "nome", nullable = false, length = 40)
	private String nome;
	
	@Column(name = "email", nullable = false, length = 40)
	private String email;
	
	@Column (name="cpf", nullable = false, length = 11)
	private String cpf;
	
	@Column(name="data_nascimento")
	@Temporal(TemporalType.DATE)
	private Date data_nasscimento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getData_nasscimento() {
		return data_nasscimento;
	}

	public void setData_nasscimento(Date data_nasscimento) {
		this.data_nasscimento = data_nasscimento;
	}




	
	
}
