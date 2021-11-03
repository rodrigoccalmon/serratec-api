package org.serratec.backend.h2banco.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Cliente {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id_cliente")
private Long id;

@NotBlank(message = "Preencha o nome")
@Size(max = 60)
@Column
private String nome;

@CPF(message = "CPF inválido")
@Column
private String cpf;

@Email(message = "E-mail inválido")
@Column
private String email;

@Embedded
private Endereco endereco;



}
