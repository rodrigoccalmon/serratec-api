package org.serratec.backend.trabalhofinalapi.controller;

import java.util.List;

import org.serratec.backend.trabalhofinalapi.domain.PedidoItem;
import org.serratec.backend.trabalhofinalapi.repository.PedidoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/pedidoitem")
public class PedidoItemController {
	
	/*@Autowired
	private PedidoItemService pedidoItemService;*/
	
	@Autowired
	private PedidoItemRepository pedidoItemRepository;
	
    @GetMapping
    @ApiOperation(value = "Listar todos os itens dos pedido", notes = "Listagem de itens dos pedidos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna todos os itens dos pedidos"),
            @ApiResponse(code = 401, message = "Erro de autenticaÃ§Ã£o" ),
            @ApiResponse(code = 403, message = "VocÃª nÃ£o tem permissÃ£o para acessar o recurso"),
            @ApiResponse(code = 404, message = "Recurso nÃ£o encontrado"),
            @ApiResponse(code = 505, message = "Quando ocorre uma exceÃ§Ã£o")
    })        
    
    public List<PedidoItem> listar(){
        return pedidoItemRepository.findAll();
    }
   
}
