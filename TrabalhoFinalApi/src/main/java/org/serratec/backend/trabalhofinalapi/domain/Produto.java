package org.serratec.backend.trabalhofinalapi.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	@ApiModelProperty(value = "Identificador único do produto", required = true)
	private Long id;
	

	@Size(max = 40)
	@Column(name = "nome_produto")
	@ApiModelProperty(value = "Nome do produto", required = true)
	private String nomeProduto;

	@Size(max = 100)
	@Column(name = "desricao_produto")
	@ApiModelProperty(value = "Descrição do produto", required = true)
	private String decricaoProduto;
	
	
	@Column(name = "quantidade_estoque")
	@ApiModelProperty(value = "Quantidade em estoque do produto", required = true)
	private int quantidadeEstoque;
	
	
	@Column(name = "data_fabricacao")
	@ApiModelProperty(value = "Data de fabricação do produto", required = true)
	private Date dataFabricacao;
	

	@Column(name = "data_cadastro")
	@ApiModelProperty(value = "Data de cadastro do produto", required = true)
	private Date dataCadastro;
	

	@Column(name = "valor_unitario")
	@ApiModelProperty(value = "Valor unitário do produto", required = true)
	private int valorUnitario;	
	
	@OneToOne
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;
	
	
	@OneToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNomeProduto() {
		return nomeProduto;
	}


	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}


	public String getDecricaoProduto() {
		return decricaoProduto;
	}


	public void setDecricaoProduto(String decricaoProduto) {
		this.decricaoProduto = decricaoProduto;
	}


	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}


	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}


	public Date getDataFabricacao() {
		return dataFabricacao;
	}


	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}


	public Date getDataCadastro() {
		return dataCadastro;
	}


	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}


	public int getValorUnitario() {
		return valorUnitario;
	}


	public void setValorUnitario(int valorUnitario) {
		this.valorUnitario = valorUnitario;
	}


	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	
	
	
	
}
