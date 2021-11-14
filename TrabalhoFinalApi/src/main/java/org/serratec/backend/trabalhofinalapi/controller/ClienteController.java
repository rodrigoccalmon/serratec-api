package org.serratec.backend.trabalhofinalapi.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.backend.trabalhofinalapi.domain.Cliente;
import org.serratec.backend.trabalhofinalapi.dto.ClienteDTO;
import org.serratec.backend.trabalhofinalapi.dto.ClienteInserirDTO;
import org.serratec.backend.trabalhofinalapi.exception.EmailException;
import org.serratec.backend.trabalhofinalapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.HttpStatus;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	@ApiOperation(value = "Listar todos os clientes", notes = "Listagem de clientes")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna todos os clientes"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Quando ocorre uma exceção") })

	public ResponseEntity<List<ClienteDTO>> pesquisarTodos() {
		return ResponseEntity.ok(clienteService.listarTodos());
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Pesquisar cliente por id", notes = "Pesquisar cliente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna todos os clientes"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Quando ocorre uma exceção") })
	public ResponseEntity<Cliente> buscar(@Valid @PathVariable Long id) {
		Optional<Cliente> cliente = clienteService.pesquisarUmCliente(id);
		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Adicionar um cliente", notes = "Adicionar cliente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna todos os clientes"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Quando ocorre uma exceção") })

	public ResponseEntity<Object> inserir(@RequestBody ClienteInserirDTO clienteInserirDTO) {
		try {
			ClienteDTO clienteDTO = clienteService.inserir(clienteInserirDTO);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(clienteDTO.getIdCliente()).toUri();
			return ResponseEntity.created(uri).body(clienteDTO);
		} catch (EmailException e) {
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		}
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Atualizar um cliente pelo id", notes = "atualizar cliente por id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna todos os clientes"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Quando ocorre uma exceção") })
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
		if (!clienteService.idExisteCliente(id)) {
			return ResponseEntity.notFound().build();
		}
		cliente.setIdCliente(id);
		cliente = clienteService.inserirCliente(cliente);
		return ResponseEntity.ok(cliente);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deletar cliente por id", notes = "Deletar cliente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna todos os clientes"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Quando ocorre uma exceção") })
	public ResponseEntity<Void> remover(@Valid @PathVariable Long id) {
		if (!clienteService.idExisteCliente(id)) {
			return ResponseEntity.notFound().build();
		}
		clienteService.removerCliente(id);
		return ResponseEntity.noContent().build();
	}
}