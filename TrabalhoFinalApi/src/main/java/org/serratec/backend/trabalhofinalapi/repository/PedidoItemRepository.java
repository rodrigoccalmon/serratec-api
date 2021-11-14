package org.serratec.backend.trabalhofinalapi.repository;

import java.util.List;

import org.serratec.backend.trabalhofinalapi.domain.PedidoItem;
import org.serratec.backend.trabalhofinalapi.domain.PedidoItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoItemRepository extends JpaRepository <PedidoItem, PedidoItemPK> {

	public List<PedidoItem> findAll();

}
