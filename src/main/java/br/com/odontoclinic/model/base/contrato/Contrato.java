package br.com.odontoclinic.model.base.contrato;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.odontoclinic.model.base.contratada.Contratada;
import br.com.odontoclinic.model.base.contratante.Contratante;
import br.com.odontoclinic.model.generic.GenericPrimaryKey;

@SuppressWarnings("serial")
@Entity
public class Contrato extends GenericPrimaryKey {
	
	//EQUIVALE A: Venda...

	//CONTRATANTE adicionada NO MOMENTO DA CRIAÇÃO DO CONTRATO
	@ManyToOne
	@JoinColumn(nullable = true)
	private Contratante contratante;

	//CONTRATADA adicionada NO MOMENTO DA CRIAÇÃO DO CONTRATO
	@ManyToOne
	@JoinColumn(nullable = true)
	private Contratada contratada;
	
	//CÓPIA DO DROGARIA..
	@Column(nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date horario;
	
	//CÓPIA DO DROGARIA..
	@Column(nullable = true, precision = 7, scale = 2)
	private BigDecimal precoTotal;

	//99.999,99
	@Column(nullable = true, precision = 7, scale = 2)
	private BigDecimal valorTotal;

	@Column(name = "periodo_vigencia", length = 30)
	private int vigencia;

	@Column(name = "dta_criacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtaCriacao;

	@Column(name = "dta_inicio")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtaInicio;

	@Column(name = "status_contratual", length = 60)
	private String statusContratual;

	@Column(name = "cogigo_ficha", length = 60)
	private String codFichaCadastral;

	public Contratante getContratante() {
		return contratante;
	}

	public void setContratante(Contratante contratante) {
		this.contratante = contratante;
	}

	public Contratada getContratada() {
		return contratada;
	}

	public void setContratada(Contratada contratada) {
		this.contratada = contratada;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public BigDecimal getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(BigDecimal precoTotal) {
		this.precoTotal = precoTotal;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getVigencia() {
		return vigencia;
	}

	public void setVigencia(int vigencia) {
		this.vigencia = vigencia;
	}

	public Date getDtaCriacao() {
		return dtaCriacao;
	}

	public void setDtaCriacao(Date dtaCriacao) {
		this.dtaCriacao = dtaCriacao;
	}

	public Date getDtaInicio() {
		return dtaInicio;
	}

	public void setDtaInicio(Date dtaInicio) {
		this.dtaInicio = dtaInicio;
	}

	public String getStatusContratual() {
		return statusContratual;
	}

	public void setStatusContratual(String statusContratual) {
		this.statusContratual = statusContratual;
	}

	public String getCodFichaCadastral() {
		return codFichaCadastral;
	}

	public void setCodFichaCadastral(String codFichaCadastral) {
		this.codFichaCadastral = codFichaCadastral;
	}
	
}
