package org.serratec.backend.trabalhofinalapi.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.trabalhofinalapi.domain.Categoria;
import org.serratec.backend.trabalhofinalapi.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;

	public Optional<Categoria> pesquisarCategoriaId(Long id) {
		return categoriaRepository.findById(id);
	}

	public boolean idExisteCategoria(Long id) {
		return categoriaRepository.existsById(id);
	}

	public Categoria inserirCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	public void removerCategoria(Long id) {
		categoriaRepository.deleteById(id);
	}

	public List<Categoria> pesquisarCategoria() {
		return categoriaRepository.findAll();
	}

}
