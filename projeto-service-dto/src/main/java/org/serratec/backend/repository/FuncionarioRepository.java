package org.serratec.backend.repository;

import org.serratec.backend.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	Funcionario findByNome(String nome);
}
