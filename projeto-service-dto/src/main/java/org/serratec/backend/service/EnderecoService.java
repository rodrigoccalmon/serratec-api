package org.serratec.backend.service;

import java.util.Optional;

import org.serratec.backend.domain.Endereco;
import org.serratec.backend.dto.EnderecoDTO;
import org.serratec.backend.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public EnderecoDTO buscar(String cep) {
		Optional<Endereco> endereco = Optional.ofNullable(enderecoRepository.findByCep(cep));
		if(endereco.isPresent()) {
			return new EnderecoDTO(endereco.get());
		} else {
			RestTemplate restTemplate = new RestTemplate();
			String uri = "https://viacep.com.br/ws/" + cep + "/json/";
			Optional<Endereco> enderecoViaCep = Optional.ofNullable(restTemplate.getForObject(uri, Endereco.class));
			if (enderecoViaCep.get().getCep() != null) {
				String cepSemTraco = enderecoViaCep.get().getCep().replaceAll("-", "");
				enderecoViaCep.get().setCep(cepSemTraco);
				return inserir(enderecoViaCep.get());
			} else {
				return null;
			}
		}
	}

	private EnderecoDTO inserir(Endereco endereco) {
		endereco = enderecoRepository.save(endereco);
		return new EnderecoDTO(endereco);
	}
}
