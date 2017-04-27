package br.com.odontoclinic.model.base.checkout.procedimento;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.odontoclinic.model.base.contrato.Contrato;
import br.com.odontoclinic.model.base.item.procedimento.ItemProcedimento;
import br.com.odontoclinic.model.generic.GenericPrimaryKey;

@SuppressWarnings("serial")
@Entity
public class CheckOutProcedimento extends GenericPrimaryKey {
	
	//EQUIVALE A: Item_Venda....
	
	//OK... CONTRATO
	@ManyToOne
	@JoinColumn(nullable = true)
	private Contrato contrato;
	
	//OK PROCEDIMENTO
	@ManyToOne
	@JoinColumn(nullable = true)
	private ItemProcedimento itemProcedimento;
	
	//CÓPIA DO DROGARIA
	@Column(nullable = true)
	private Short quantidade;
	
	//CÓPIA DO DROGARIA
	@Column(nullable = true, precision = 7, scale = 2)
	private BigDecimal precoParcial;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtaVenda;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtaAlteracao;
	
	//Status da Operação.. Inicialmente toda venda fica com "FINALIZADA" 
	//depois "CAIXA" quando houver o pagamento final no caixa da empresa...
	@Column(name = "status_operacao", length = 60)
	private String statusOperacao;
	
	@Column(name = "valor_parcial", nullable = true, precision = 7, scale = 2)
	//9.999,99
	private BigDecimal valorParcial;
	
	//CAMPO PREVISTO PARA DESCONTO OU SEJA O VALOR EM R$ DO DESCONTO..
	
	//CAMPO COM O CÁLCULO DO PREÇO PARCIAL DO ITEM (MENOS) O VALOR DO DESCONTO...
	
	//LOCALIZAÇÃO DO DENTE NA ARCADA SEGUNDO A NOTAÇÃO CDI OU AFINS.. ACESSADA VIA ENUM...
	@Column(name = "notacao_dente", length = 60)
	private String notacaoCdiDente;

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public ItemProcedimento getItemProcedimento() {
		return itemProcedimento;
	}

	public void setItemProcedimento(ItemProcedimento itemProcedimento) {
		this.itemProcedimento = itemProcedimento;
	}

	public Short getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Short quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPrecoParcial() {
		return precoParcial;
	}

	public void setPrecoParcial(BigDecimal precoParcial) {
		this.precoParcial = precoParcial;
	}

	public Date getDtaVenda() {
		return dtaVenda;
	}

	public void setDtaVenda(Date dtaVenda) {
		this.dtaVenda = dtaVenda;
	}

	public Date getDtaAlteracao() {
		return dtaAlteracao;
	}

	public void setDtaAlteracao(Date dtaAlteracao) {
		this.dtaAlteracao = dtaAlteracao;
	}

	public String getStatusOperacao() {
		return statusOperacao;
	}

	public void setStatusOperacao(String statusOperacao) {
		this.statusOperacao = statusOperacao;
	}

	public BigDecimal getValorParcial() {
		return valorParcial;
	}

	public void setValorParcial(BigDecimal valorParcial) {
		this.valorParcial = valorParcial;
	}
	
	public String getNotacaoCdiDente() {
		return notacaoCdiDente;
	}
	
	public void setNotacaoCdiDente(String notacaoCdiDente) {
		this.notacaoCdiDente = notacaoCdiDente;
	}
	
}
