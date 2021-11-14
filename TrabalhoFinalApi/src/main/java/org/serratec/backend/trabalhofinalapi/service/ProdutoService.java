package org.serratec.backend.trabalhofinalapi.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.trabalhofinalapi.domain.Produto;
import org.serratec.backend.trabalhofinalapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Optional<Produto> pesquisarProdutoId(Long id) {
		return produtoRepository.findById(id);
	}

	public boolean idExisteProduto(Long id) {
		return produtoRepository.existsById(id);
	}

	public Produto inserirProduto(Produto produto) {
		return produtoRepository.save(produto);
	}

	public void removerProduto(Long id) {
		produtoRepository.deleteById(id);
	}

	public List<Produto> pesquisarProduto() {
		return produtoRepository.findAll();
	}
	
}
