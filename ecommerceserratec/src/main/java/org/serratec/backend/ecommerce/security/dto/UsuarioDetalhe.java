package org.serratec.backend.ecommerce.security.dto;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.serratec.backend.ecommerce.entity.Usuario;
import org.serratec.backend.ecommerce.entity.UsuarioPerfil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioDetalhe implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Optional<Usuario> usuario;
	
	public UsuarioDetalhe(Optional<Usuario> usuario) {
		this.setUsuario(usuario);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> grantedAuthority = new HashSet<>();
		for (UsuarioPerfil usuarioPerfil : usuario.get().getUsuarioPerfis()) {
			grantedAuthority.add(new SimpleGrantedAuthority((usuarioPerfil.getId().getPerfil().getNome())));
		}
		return grantedAuthority;
	}

	@Override
	public String getPassword() {
		return usuario.get().getSenha();
	}

	@Override
	public String getUsername() {
		return usuario.get().getNome();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Optional<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(Optional<Usuario> usuario) {
		this.usuario = usuario;
	}

}
