package org.serratec.backend.ecommerce.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class UsuarioPerfil {

	@EmbeddedId
	private UsuarioPerfilPK id = new UsuarioPerfilPK();
	
	public UsuarioPerfilPK getId() {
		return id;
	}

	public void setId(UsuarioPerfilPK id) {
		this.id = id;
	}
}
