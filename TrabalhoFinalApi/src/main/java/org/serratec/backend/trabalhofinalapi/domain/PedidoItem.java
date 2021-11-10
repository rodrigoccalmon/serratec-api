package org.serratec.backend.trabalhofinalapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class PedidoItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedidoItem")
	@ApiModelProperty(value = "Identificador único do pedido item", required = true)
	private Long idPedidoItem;

	@NotBlank
	@Size(max = 10000)
	@Column(name = "qtdItem")
	@ApiModelProperty(value = "Quantidade de Items", required = true)
	private int qtdItem;

	@OneToOne
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;

	@OneToOne
	@JoinColumn(name = "id_produto")
	private Produto produto;

	public Long getIdPedidoItem() {
		return idPedidoItem;
	}

	public void setIdPedidoItem(Long idPedidoItem) {
		this.idPedidoItem = idPedidoItem;
	}

	public int getQtdItem() {
		return qtdItem;
	}

	public void setQtdItem(int qtdItem) {
		this.qtdItem = qtdItem;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	

}
