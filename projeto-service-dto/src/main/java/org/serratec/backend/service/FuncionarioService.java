package org.serratec.backend.service;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.controller.FuncionarioDTO;
import org.serratec.backend.domain.Funcionario;
import org.serratec.backend.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private FotoService fotoService;
	
	public List<FuncionarioDTO> buscarTodos() {
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		List<FuncionarioDTO> funcionariosDTO = new ArrayList<>();
		funcionarios.forEach(f -> funcionariosDTO.add(adicionarImagemUri(f)));
		return funcionariosDTO;
	}
	
	public FuncionarioDTO buscar(Long id) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		return adicionarImagemUri(funcionario.get());
	}
	
	public FuncionarioDTO inserir(Funcionario funcionario, MultipartFile file) throws IOException {
		fotoService.inserir(funcionarioRepository.save(funcionario), file);
		return adicionarImagemUri(funcionario);
	}

	private FuncionarioDTO adicionarImagemUri(Funcionario f) {
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("funcionarios/{id}/foto")
				.buildAndExpand(f.getId()).toUri();
		FuncionarioDTO dto = new FuncionarioDTO();
		dto.setNome(f.getNome());
		dto.setUrl(uri.toString());
		return dto;
	}
	
	
}
