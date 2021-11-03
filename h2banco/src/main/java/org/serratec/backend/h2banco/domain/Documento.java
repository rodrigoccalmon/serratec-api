package org.serratec.backend.h2banco.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;



@Entity
public class Documento {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id_documento")
private Long id;

@Column
private String identidade;

@Column(name = "orgao_expedidor")
private String orgaoExpedidor;

@Column
private String cnh;

@Column(name = "titulo_eleitor")
private String tituloEleitor;

@OneToOne
@JoinColumn(name = "id_cliente")
private Cliente cliente;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getIdentidade() {
	return identidade;
}

public void setIdentidade(String identidade) {
	this.identidade = identidade;
}

public String getOrgaoExpedidor() {
	return orgaoExpedidor;
}

public void setOrgaoExpedidor(String orgaoExpedidor) {
	this.orgaoExpedidor = orgaoExpedidor;
}

public String getCnh() {
	return cnh;
}

public void setCnh(String cnh) {
	this.cnh = cnh;
}

public String getTituloEleitor() {
	return tituloEleitor;
}

public void setTituloEleitor(String tituloEleitor) {
	this.tituloEleitor = tituloEleitor;
}

public Cliente getCliente() {
	return cliente;
}

public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}
  
}
