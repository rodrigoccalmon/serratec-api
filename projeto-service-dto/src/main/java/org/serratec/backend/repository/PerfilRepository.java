package org.serratec.backend.repository;

import org.serratec.backend.domain.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil, Long>{
	Perfil findByNome(String name);
}
