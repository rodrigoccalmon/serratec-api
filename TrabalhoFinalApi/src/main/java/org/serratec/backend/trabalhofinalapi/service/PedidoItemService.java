/*package org.serratec.backend.trabalhofinalapi.service;

import java.util.List;

import org.serratec.backend.trabalhofinalapi.domain.PedidoItem;
import org.serratec.backend.trabalhofinalapi.repository.PedidoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class PedidoItemService {

	@Autowired
	private PedidoItemRepository pedidoItemRepository;
	
	public ResponseEntity<List<PedidoItem>> pesquisar() {
		List<PedidoItem> pedidoItem = this.pedidoItemRepository.findAll();
		return ResponseEntity.ok(pedidoItem);
	}


}



*/