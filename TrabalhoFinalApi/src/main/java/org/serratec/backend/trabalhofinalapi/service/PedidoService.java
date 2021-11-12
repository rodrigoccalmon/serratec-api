package org.serratec.backend.trabalhofinalapi.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.trabalhofinalapi.domain.Pedido;
import org.serratec.backend.trabalhofinalapi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	
	public Optional<Pedido> pesquisarPedidoId(Long id) {
		return pedidoRepository.findById(id);
	}

	public boolean idExistePedido(Long id) {
		return pedidoRepository.existsById(id);
	}

	public Pedido inserirPedido(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	public void removerPedido(Long id) {
		pedidoRepository.deleteById(id);
	}

	public List<Pedido> pesquisarPedido() {
		return pedidoRepository.findAll();
	}
	
}
