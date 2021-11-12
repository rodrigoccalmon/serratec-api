package org.serratec.backend.trabalhofinalapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.backend.trabalhofinalapi.domain.Pedido;
import org.serratec.backend.trabalhofinalapi.service.PedidoService;
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
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	
    @GetMapping
    @ApiOperation(value = "Listar todos os pedidos", notes = "Listagem de pedidos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna todos os produtos"),
            @ApiResponse(code = 401, message = "Erro de autenticação" ),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 505, message = "Quando ocorre uma exceção")
    })        
    
    public List<Pedido> listar() {
        return pedidoService.pesquisarPedido();
    }
    
    @GetMapping("/{id}")    
    @ApiOperation(value = "Pesquisar pedido por id", notes = "Pesquisar pedido")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna todos os clientes"),
            @ApiResponse(code = 401, message = "Erro de autenticação" ),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 505, message = "Quando ocorre uma exceção")
    })    
    public ResponseEntity<Pedido> buscar(@Valid @PathVariable Long id) {
        Optional<Pedido> pedido = pedidoService.pesquisarPedidoId(id);
        if (pedido.isPresent()) {
            return ResponseEntity.ok(pedido.get());
        }
        return ResponseEntity.notFound().build();
    }
    
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Adicionar um pedido", notes = "Adicionar pedido")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pedido adicionado"),
            @ApiResponse(code = 401, message = "Erro de autenticação" ),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 505, message = "Quando ocorre uma exceção")
    })    
    public Pedido inserir(@Valid @RequestBody Pedido pedido) {
        return pedidoService.inserirPedido(pedido);
        
    }
    
    @PutMapping("/{id}")
    @ApiOperation(value = "Atualizar um pedido pelo id", notes = "atualizar pedido por id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pedido atualizado"),
            @ApiResponse(code = 401, message = "Erro de autenticação" ),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 505, message = "Quando ocorre uma exceção")
    })    
    public ResponseEntity<Pedido> atualizar(@PathVariable Long id, @Valid @RequestBody Pedido pedido) {
        if (!pedidoService.idExistePedido(id)) {
            return ResponseEntity.notFound().build();
        }
        pedido.setId(id);
        pedido = pedidoService.inserirPedido(pedido);
        return ResponseEntity.ok(pedido);
    }
    
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deletar pedido por id", notes = "Deletar pedido")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pedido deletado"),
            @ApiResponse(code = 401, message = "Erro de autenticação" ),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 505, message = "Quando ocorre uma exceção")
    })    
    public ResponseEntity<Void> remover (@Valid @PathVariable Long id) {
        if (!pedidoService.idExistePedido(id)) {
            return ResponseEntity.notFound().build();
        }
        pedidoService.removerPedido(id);
        return ResponseEntity.noContent().build();
    }
	
}
