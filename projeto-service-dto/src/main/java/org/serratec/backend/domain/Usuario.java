package org.serratec.backend.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.serratec.backend.dto.UsuarioRequestDTO;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id;
	
	private String nome;
	private String email;
	private String senha;
	
	@ManyToOne
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;

	@OneToMany(mappedBy = "id.usuario", cascade = CascadeType.PERSIST)
	private Set<UsuarioPerfil> usuarioPerfis = new HashSet<>();
	
	public Usuario() {
		super();
	}
	
	public Usuario(UsuarioRequestDTO usuarioRequest) {
		super();
		this.nome = usuarioRequest.getNome();
		this.email = usuarioRequest.getEmail();
		this.senha = usuarioRequest.getSenha();
	}
	
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Set<UsuarioPerfil> getUsuarioPerfis() {
		return usuarioPerfis;
	}
	public void setUsuarioPerfis(Set<UsuarioPerfil> usuarioPerfis) {
		this.usuarioPerfis = usuarioPerfis;
	}
}
