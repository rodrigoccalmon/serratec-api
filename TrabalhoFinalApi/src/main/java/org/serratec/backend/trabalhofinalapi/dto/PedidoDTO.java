package org.serratec.backend.trabalhofinalapi.dto;


import java.util.Date;

public class PedidoDTO {
	private Long idPedido;
	private Date dataPedido;
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
	public PedidoDTO(Long idPedido, Date dataPedido) {
		super();
		this.idPedido = idPedido;
		this.dataPedido = dataPedido;
	}
	public PedidoDTO() {
		super();
	}

}
