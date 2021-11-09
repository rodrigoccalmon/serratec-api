package org.serratec.backend.controller;

import java.io.IOException;

import org.serratec.backend.domain.Foto;
import org.serratec.backend.domain.Funcionario;
import org.serratec.backend.service.FotoService;
import org.serratec.backend.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;
	@Autowired
	private FotoService fotoService;
	
	@GetMapping("/{id}/foto")
	public ResponseEntity<byte[]> buscarPorFoto(@PathVariable Long id) {
		Foto foto = fotoService.buscarFoto(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-type", foto.getTipo());
		headers.add("content-lenght", String.valueOf(foto.getDados().length));
		return new ResponseEntity<>(foto.getDados(), headers, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public FuncionarioDTO buscar(@PathVariable Long id) {
		return funcionarioService.buscar(id);
	}
	
	@PostMapping
	public FuncionarioDTO inserir(@RequestParam MultipartFile file, 
			@RequestPart Funcionario funcionario) throws IOException {
		return funcionarioService.inserir(funcionario, file);
	}
}
