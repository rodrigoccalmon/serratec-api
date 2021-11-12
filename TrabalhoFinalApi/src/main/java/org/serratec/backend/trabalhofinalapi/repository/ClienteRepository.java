package org.serratec.backend.trabalhofinalapi.repository;

import org.serratec.backend.trabalhofinalapi.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  ClienteRepository extends JpaRepository<Cliente, Long> {

	Cliente findByEmailCliente(String emailCliente);

}
