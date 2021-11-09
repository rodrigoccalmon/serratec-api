package org.serratec.backend.repository;

import org.serratec.backend.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	Endereco findByCep(String cep);
}
