package org.serratec.backend.trabalhofinalapi.controller;

import org.serratec.backend.trabalhofinalapi.domain.Endereco;
import org.serratec.backend.trabalhofinalapi.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@GetMapping("{cep}")
	public ResponseEntity<Endereco> buscar(@PathVariable String cep) {
		Endereco enderecoDTO = enderecoRepository.findByCep(cep);
		
		if (enderecoDTO == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(enderecoDTO);
		}
	}
}
