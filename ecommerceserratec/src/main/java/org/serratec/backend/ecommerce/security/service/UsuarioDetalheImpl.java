package org.serratec.backend.ecommerce.security.service;

import java.util.Optional;

import org.serratec.backend.ecommerce.entity.Usuario;
import org.serratec.backend.ecommerce.security.dto.UsuarioDetalhe;
import org.serratec.backend.ecommerce.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetalheImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepository.findByNome(username);
		if (!usuario.isPresent()) {
			throw new RuntimeException();
		}
		return new UsuarioDetalhe(usuario); 
	}

}
