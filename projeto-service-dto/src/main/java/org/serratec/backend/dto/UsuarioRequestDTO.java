package org.serratec.backend.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.serratec.backend.domain.Usuario;

public class UsuarioRequestDTO {

	private String nome;
	private String email;
	private String senha;
	@Enumerated(EnumType.STRING)
	private Set<PerfilEnum> perfis = new HashSet<>();

	public UsuarioRequestDTO() {
	}
	
	public UsuarioRequestDTO(Usuario usuario) {
		super();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
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
	public Set<PerfilEnum> getPerfis() {
		return perfis;
	}
	public void setPerfis(Set<PerfilEnum> perfis) {
		this.perfis = perfis;
	}
}
