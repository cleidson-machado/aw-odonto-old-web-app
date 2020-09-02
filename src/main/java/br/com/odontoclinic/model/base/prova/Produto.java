package br.com.odontoclinic.model.base.prova;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.odontoclinic.model.generic.GenericPrimaryKey;

@SuppressWarnings("serial")
@Entity
public class Produto extends GenericPrimaryKey {
	
	//ATRIBUTOS.. TESTE NASTEK
	@Column(name = "DESCRICAO", length = 50)
	private String descricao;
	
	@Column(name = "CODIGO_FABRICA", length = 50)
	private String codigoFabrica;
	
	@Column(name = "PRECO_BASE", nullable = true, precision = 6, scale = 2)
	private BigDecimal precoBase;
	
	@Column(name = "DATA_CAD_PRODUTO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadProduto;
	
	@Column(name = "QTD_EM_ESTOQUE", nullable = true)
	private Short qtdEmEstoque;
	
	@Column(name = "CATEGORIA", length = 50)
	private String categoria;
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodigoFabrica() {
		return codigoFabrica;
	}

	public void setCodigoFabrica(String codigoFabrica) {
		this.codigoFabrica = codigoFabrica;
	}

	public BigDecimal getPrecoBase() {
		return precoBase;
	}

	public void setPrecoBase(BigDecimal precoBase) {
		this.precoBase = precoBase;
	}

	public Date getDataCadProduto() {
		return dataCadProduto;
	}

	public void setDataCadProduto(Date dataCadProduto) {
		this.dataCadProduto = dataCadProduto;
	}

	public Short getQtdEmEstoque() {
		return qtdEmEstoque;
	}

	public void setQtdEmEstoque(Short qtdEmEstoque) {
		this.qtdEmEstoque = qtdEmEstoque;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
