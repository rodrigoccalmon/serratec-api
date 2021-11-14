package org.serratec.backend.trabalhofinalapi.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class PedidoItem  {

	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedidoItem")
	@ApiModelProperty(value = "Identificador único do pedido item")
	private PedidoItemPK PedidoItemPK = new PedidoItemPK();
	
	@ManyToOne
	private Pedido pedido;

	@ManyToOne
	private Produto produto;

	@NotBlank
	@Size(max = 10000)
	@Column(name = "qtd_itens")
	@ApiModelProperty(value = "Quantidade de Items")
	private int qtdItem;
	
	private Double valorTotalItens;

	public PedidoItemPK getPedidoItemPK() {
		return PedidoItemPK;
	}

	public void setPedidoItemPK(PedidoItemPK pedidoItemPK) {
		PedidoItemPK = pedidoItemPK;
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

	public int getQtdItem() {
		return qtdItem;
	}

	public void setQtdItem(int qtdItem) {
		this.qtdItem = qtdItem;
	}

	public Double getValorTotalItens() {
		return valorTotalItens;
	}

	public void setValorTotalItens(Double valorTotalItens) {
		this.valorTotalItens = valorTotalItens;
	}

	public PedidoItem(org.serratec.backend.trabalhofinalapi.domain.PedidoItemPK pedidoItemPK, Pedido pedido,
			Produto produto, @NotBlank @Size(max = 10000) int qtdItem, Double valorTotalItens) {
		super();
		PedidoItemPK = pedidoItemPK;
		this.pedido = pedido;
		this.produto = produto;
		this.qtdItem = qtdItem;
		this.valorTotalItens = valorTotalItens;
	}

	public PedidoItem() {
		super();
	}

	
	

}
