package org.serratec.backend.trabalhofinalapi.service;


import org.serratec.backend.trabalhofinalapi.domain.Endereco;
import org.serratec.backend.trabalhofinalapi.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


@Service
public class EnderecoService {

	@SuppressWarnings("unused")
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Endereco buscarCep(String cep) throws HttpClientErrorException {
		
		RestTemplate restTemplate = new RestTemplate();
		String uri = "https://viacep.com.br/ws/" + cep + "/json/";
		Endereco enderecoViaCep = restTemplate.getForObject(uri, Endereco.class);
		
		String cepSemTraco = enderecoViaCep.getCep().replaceAll("-", "");
		enderecoViaCep.setCep(cepSemTraco);
		return enderecoViaCep;
		
	}
}
