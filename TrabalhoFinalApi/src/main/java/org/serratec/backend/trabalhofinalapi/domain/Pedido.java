package org.serratec.backend.trabalhofinalapi.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import io.swagger.annotations.ApiModelProperty;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	@ApiModelProperty(value = "Identificador único do pedido", required = true)
	private Long idPedido;

	@Column(name = "data_pedido")
	@ApiModelProperty(value = "Data do pedido", required = true)
	private Date dataPedido;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente Cliente;
	
	
	@OneToMany(mappedBy = "PedidoItemPK.pedido", fetch = FetchType.EAGER)
	@ApiModelProperty(value = "Lista de Itens do Pedido")
	private Set<PedidoItem> pedidoItens = new HashSet<>();
	
	
/*	@OneToOne
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;
*/
	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Cliente getCliente() {
		return Cliente;
	}

	public void setCliente(Cliente cliente) {
		Cliente = cliente;
	}

	public void setId(Long id) {
		// TODO Auto-generated method stub
		
	}

/*	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
*/
	

}
