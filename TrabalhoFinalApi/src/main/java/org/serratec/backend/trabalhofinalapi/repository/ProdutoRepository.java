package org.serratec.backend.trabalhofinalapi.repository;

import org.serratec.backend.trabalhofinalapi.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
