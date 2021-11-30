package org.serratec.backend.ecommerce.security.repository;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.ecommerce.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	List<Usuario> findByEmail(String email);
	Optional<Usuario> findByNome(String nome);
}
