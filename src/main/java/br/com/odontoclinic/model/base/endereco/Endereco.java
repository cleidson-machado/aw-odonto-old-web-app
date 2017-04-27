package br.com.odontoclinic.model.base.endereco;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.odontoclinic.model.base.contratante.Contratante;
import br.com.odontoclinic.model.base.referencia.Referencia;
import br.com.odontoclinic.model.generic.GenericEndereco;

@SuppressWarnings("serial")
@Entity
public class Endereco extends GenericEndereco {

	//ESSE RÓTULO LEVA O NOME DA ENTIDADE EM MAÍSCULO: CONTRATANTE, REFERENCIA, CONTRATADA, PACIENTE
	@Column(length = 20)
	private String rotulagem;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dta_cadastro")
	private Date DtaCadastro;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dta_alteracao")
	private Date DtaAlteracao;
	
	//Muitos endereços para uma Contratante...
	//VAI criar aqui a Coluna com a FK..
	@ManyToOne
	@JoinColumn(nullable = true)
	private Contratante contratante;
	
	//Muitos endereços para uma Referencia...
	//VAI criar aqui a Coluna com a FK..
	@ManyToOne
	@JoinColumn(nullable = true)
	private Referencia referencia;

	//ADICIONAR DEPOIS TODAS AS OUTRAS ENTIDADES QUE VÃO USAR OS ATRIBUTOS DE ENDEREÇAMENTO
	//EXATAMENTE COMO REFERENCIA E OU CONTRATANTE...
	
	public String getRotulagem() {
		return rotulagem;
	}
	
	public void setRotulagem(String rotulagem) {
		this.rotulagem = rotulagem;
	}

	public Date getDtaCadastro() {
		return DtaCadastro;
	}

	public void setDtaCadastro(Date dtaCadastro) {
		DtaCadastro = dtaCadastro;
	}

	public Date getDtaAlteracao() {
		return DtaAlteracao;
	}

	public void setDtaAlteracao(Date dtaAlteracao) {
		DtaAlteracao = dtaAlteracao;
	}

	public Contratante getContratante() {
		return contratante;
	}

	public void setContratante(Contratante contratante) {
		this.contratante = contratante;
	}

	public Referencia getReferencia() {
		return referencia;
	}

	public void setReferencia(Referencia referencia) {
		this.referencia = referencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((DtaAlteracao == null) ? 0 : DtaAlteracao.hashCode());
		result = prime * result + ((DtaCadastro == null) ? 0 : DtaCadastro.hashCode());
		result = prime * result + ((contratante == null) ? 0 : contratante.hashCode());
		result = prime * result + ((referencia == null) ? 0 : referencia.hashCode());
		result = prime * result + ((rotulagem == null) ? 0 : rotulagem.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (DtaAlteracao == null) {
			if (other.DtaAlteracao != null)
				return false;
		} else if (!DtaAlteracao.equals(other.DtaAlteracao))
			return false;
		if (DtaCadastro == null) {
			if (other.DtaCadastro != null)
				return false;
		} else if (!DtaCadastro.equals(other.DtaCadastro))
			return false;
		if (contratante == null) {
			if (other.contratante != null)
				return false;
		} else if (!contratante.equals(other.contratante))
			return false;
		if (referencia == null) {
			if (other.referencia != null)
				return false;
		} else if (!referencia.equals(other.referencia))
			return false;
		if (rotulagem == null) {
			if (other.rotulagem != null)
				return false;
		} else if (!rotulagem.equals(other.rotulagem))
			return false;
		return true;
	}
	
}
