package org.serratec.backend.trabalhofinalapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.backend.trabalhofinalapi.domain.Categoria;
import org.serratec.backend.trabalhofinalapi.service.CategoriaService;
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
import org.springframework.http.HttpStatus;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	@ApiOperation(value = "Lista todas categorias", notes = "Listagem de categoria")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna todas as categorias"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Quando ocorre uma exceção") })

	public List<Categoria> listar() {
		return categoriaService.pesquisarCategoria();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Pesquisar categoria por id", notes = "Pesquisar categoria")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna categorias"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Quando ocorre uma exceção") })
	public ResponseEntity<Categoria> buscar(@Valid @PathVariable Long id) {
		Optional<Categoria> categoria = categoriaService.pesquisarCategoriaId(id);
		if (categoria.isPresent()) {
			return ResponseEntity.ok(categoria.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Adicionar uma categoria", notes = "Adicionar categoria")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna todas as categorias"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Quando ocorre uma exceção") })
	public Categoria inserir(@Valid @RequestBody Categoria categoria) {
		return categoriaService.inserirCategoria(categoria);

	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Atualizar uma categoria pelo id", notes = "atualizar categoria por id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna categorias"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Quando ocorre uma exceção") })
	public ResponseEntity<Categoria> atualizar(@PathVariable Long id, @Valid @RequestBody Categoria categoria) {
		if (!categoriaService.idExisteCategoria(id)) {
			return ResponseEntity.notFound().build();
		}
		categoria.setIdCategoria(id);
		categoria = categoriaService.inserirCategoria(categoria);
		return ResponseEntity.ok(categoria);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deletar categoria por id", notes = "Deletar categoria")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna todos as categorias"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Quando ocorre uma exceção") })
	public ResponseEntity<Void> remover(@Valid @PathVariable Long id) {
		if (!categoriaService.idExisteCategoria(id)) {
			return ResponseEntity.notFound().build();
		}
		categoriaService.removerCategoria(id);
		return ResponseEntity.noContent().build();
	}
}