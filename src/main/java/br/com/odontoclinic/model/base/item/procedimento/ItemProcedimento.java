package br.com.odontoclinic.model.base.item.procedimento;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Transient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.odontoclinic.model.generic.GenericPrimaryKey;

@SuppressWarnings("serial")
@Entity
public class ItemProcedimento extends GenericPrimaryKey {
	
	//EQUIVALE A: Produto...
	
	@Column(name = "nome_item", length = 60)
	String nomeItem;
	
	//TIPO SKU.. cada item cadastrado aqui deve ter um código único..
	//ESTUDAR O USO DO CÓDIGO DE BARRAS... aqui!
	@Column(name = "codigo_item", length = 60)
	private String codigoItem;
	
	//CÓPIA DO DROGARIA
	@Column(length = 80, nullable = true)
	private String descricao;
	
	//CÓPIA DO DROGARIA
	@Column(nullable = true)
	private Short quantidade;
	
	//CÓPIA DO DROGARIA
	@Column(nullable = true, precision = 6, scale = 2)
	private BigDecimal preco;
	
	//CÓPIA DO DROGARIA
	@Transient
	private String caminho;
	
	@Column( name = "valor_atual", nullable = true, precision = 6, scale = 2 )
	//9.999,99
	private BigDecimal valorAtual;
	
	@Column( name = "valor_antigo", nullable = true, precision = 6, scale = 2 )
	//9.999,99
	private BigDecimal valorAntigo;
	
	@Column
	private int estoque;
	
	//LOCALIZAÇÃO DO DENTE NA ARCADA SEGUNDO A NOTAÇÃO CDI OU AFINS.. ACESSADA VIA ENUM...
	@Column(name = "notacao_dente", length = 60)
	private String notacaoCdiDente;
	
	@Column(nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtaCriacao;
	
	@Column(nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtaAlteraValor;

	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	public String getCodigoItem() {
		return codigoItem;
	}

	public void setCodigoItem(String codigoItem) {
		this.codigoItem = codigoItem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Short getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Short quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public BigDecimal getValorAtual() {
		return valorAtual;
	}

	public void setValorAtual(BigDecimal valorAtual) {
		this.valorAtual = valorAtual;
	}

	public BigDecimal getValorAntigo() {
		return valorAntigo;
	}

	public void setValorAntigo(BigDecimal valorAntigo) {
		this.valorAntigo = valorAntigo;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public Date getDtaCriacao() {
		return dtaCriacao;
	}

	public void setDtaCriacao(Date dtaCriacao) {
		this.dtaCriacao = dtaCriacao;
	}

	public Date getDtaAlteraValor() {
		return dtaAlteraValor;
	}

	public void setDtaAlteraValor(Date dtaAlteraValor) {
		this.dtaAlteraValor = dtaAlteraValor;
	}
	
	public String getNotacaoCdiDente() {
		return notacaoCdiDente;
	}
	
	public void setNotacaoCdiDente(String notacaoCdiDente) {
		this.notacaoCdiDente = notacaoCdiDente;
	}
	
}
