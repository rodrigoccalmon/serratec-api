package org.serratec.backend.ecommerce.controller;

import org.serratec.backend.ecommerce.entity.Usuario;
import org.serratec.backend.ecommerce.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping
	public ResponseEntity<Usuario> auth(@RequestBody Usuario usuario) {
		usuario.setNome(usuario.getNome());
		usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
		usuario.setEmail("macana.davi@gmail.com");
		return ResponseEntity.ok(usuarioRepository.save(usuario));
	}
}
