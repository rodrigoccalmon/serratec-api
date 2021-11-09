package org.serratec.backend.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.serratec.backend.domain.Endereco;
import org.serratec.backend.domain.Usuario;
import org.serratec.backend.domain.UsuarioPerfil;

public class UsuarioResponseDTO {

	private Long id;
	private String nome;
	private String email;
	private Endereco endereco;
	@Enumerated(EnumType.STRING)
	private Set<PerfilEnum> perfis = new HashSet<>();

	public UsuarioResponseDTO() {
	}
	
	public UsuarioResponseDTO(Usuario usuario) {
		super();
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.endereco = usuario.getEndereco();
		
		for (UsuarioPerfil usuarioPerfil : usuario.getUsuarioPerfis()) {
			this.getPerfis().add(PerfilEnum.valueOf(usuarioPerfil.getId().getPerfil().getNome()));
		}
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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Set<PerfilEnum> getPerfis() {
		return perfis;
	}
	public void setPerfis(Set<PerfilEnum> perfis) {
		this.perfis = perfis;
	}
}
