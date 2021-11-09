package org.serratec.backend.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.config.MailConfig;
import org.serratec.backend.domain.Perfil;
import org.serratec.backend.domain.Usuario;
import org.serratec.backend.domain.UsuarioPerfil;
import org.serratec.backend.dto.PerfilEnum;
import org.serratec.backend.dto.UsuarioRequestDTO;
import org.serratec.backend.dto.UsuarioResponseDTO;
import org.serratec.backend.repository.PerfilRepository;
import org.serratec.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	@Autowired
	private MailConfig mail;
	
	public List<UsuarioResponseDTO> pesquisarTodos() {
		// LISTA DE USUARIOS QUE VEM DO BANCO
		List<Usuario> usuarios = usuarioRepository.findAll();
		
		// LISTA DE USUÁRIOS VAZIA QUE SERÁ PREENCHIDA COM O QUE VEM DO BANCO 
		List<UsuarioResponseDTO> usuariosDTO = new ArrayList<UsuarioResponseDTO>();
		
		// LOOP COM A LISTA DE USUÁRIOS QUE VEM DO BANCO
		for (Usuario usuario : usuarios) {
			// INSTÂNCIANDO UM USUARIO DTO E USANDO SEU CONSTRUTOR PARA PASSAR PARÂMETRO
			UsuarioResponseDTO usuarioDTO = new UsuarioResponseDTO(usuario);
			// ADICIONANDO O USUÁRIO CRIANDO E PREENCHIDO ACIMA NA LISTA CRIADA NA LINHA 28
			usuariosDTO.add(usuarioDTO);
		}
		// RETORNANDO A LISTA PREENCHIDA
		return usuariosDTO;
	}

	public UsuarioResponseDTO inserir(UsuarioRequestDTO usuarioRequestDTO) {
//		Usuario usuarioBanco = usuarioRepository.findByEmail(usuarioRequestDTO.getEmail());
//		if (usuarioBanco != null) {
//			throw new EmailException("Email já existente");
//		}
		Usuario usuario = new Usuario(usuarioRequestDTO);
		usuario.setSenha(bCryptPasswordEncoder.encode(usuarioRequestDTO.getSenha())); 
		
		// LOOP COM A LISTA DE PERFIS QUE VEM DA REQUISIÇÃO (POSTMAN)
		for (PerfilEnum perfilEnum : usuarioRequestDTO.getPerfis()) {
			Perfil perfil = perfilRepository.findByNome(perfilEnum.name());
			UsuarioPerfil usuarioPerfil = new UsuarioPerfil(usuario, perfil, LocalDate.now());
			usuario.getUsuarioPerfis().add(usuarioPerfil);
		}
		
		usuarioRepository.save(usuario);
//		mail.sendEmail(usuario.getEmail(), "Usuário cadastrado", 
//				"Você foi cadastrado com usuário " + usuario.getNome() + " e email " + usuario.getEmail());
		return new UsuarioResponseDTO(usuario);
	}
}
