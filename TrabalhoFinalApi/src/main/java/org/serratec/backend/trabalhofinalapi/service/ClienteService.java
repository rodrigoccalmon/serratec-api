package org.serratec.backend.trabalhofinalapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.serratec.backend.trabalhofinalapi.config.MailConfig;
import org.serratec.backend.trabalhofinalapi.domain.Cliente;
import org.serratec.backend.trabalhofinalapi.dto.ClienteDTO;
import org.serratec.backend.trabalhofinalapi.dto.ClienteInserirDTO;
import org.serratec.backend.trabalhofinalapi.exception.EmailException;
import org.serratec.backend.trabalhofinalapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private MailConfig mailConfig;
	
	
	@Autowired
	private EnderecoService enderecoService;
	

	public List<ClienteDTO> listarTodos() {
		List<Cliente> clientes = clienteRepository.findAll();
		List<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();

		for (Cliente cliente : clientes) {
			ClienteDTO clienteDTO = new ClienteDTO(cliente);
			clientesDTO.add(clienteDTO);
		}
		return clientesDTO;
	}

	public Optional<Cliente> pesquisarUmCliente(Long id) {
		return clienteRepository.findById(id);
	}

	public boolean idExisteCliente(Long id) {
		return clienteRepository.existsById(id);
	}

	public Cliente inserirCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public void removerCliente(Long id) {
		clienteRepository.deleteById(id);
	}

	public ClienteDTO inserir(ClienteInserirDTO clienteInserirDTO) throws EmailException {

		if (clienteRepository.findByEmailCliente(clienteInserirDTO.getEmailCliente()) != null) {
			throw new EmailException("Email já existente !!");
		}
		Cliente cliente = new Cliente();
		cliente.setNomeCliente(clienteInserirDTO.getNomeCliente());
		cliente.setEmailCliente(clienteInserirDTO.getEmailCliente());
		cliente.setCpfCliente(clienteInserirDTO.getCpfCliente());
		cliente.setEndereco(enderecoService.buscarCep(clienteInserirDTO.getCep()));				
		cliente = clienteRepository.save(cliente);
		mailConfig.sendEmail(cliente.getEmailCliente(), "Cadastro de Usuario !!", cliente.toString());
		return new ClienteDTO(cliente);

	}

}
