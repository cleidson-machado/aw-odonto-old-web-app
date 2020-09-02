package br.com.odontoclinic.model.base.prova;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.odontoclinic.model.generic.GenericPrimaryKey;

@SuppressWarnings("serial")
@Entity
public class Imovel extends GenericPrimaryKey {
	
	@Column(name = "ZONA", length = 5)
	private String Zona;
	
	@Column(name = "SETOR", length = 5)
	private String Setor;
	
	@Column(name = "QUADRA", length = 5)
	private String Quadra;
	
	@Column(name = "LOTE", length = 5)
	private String Lote;
	
	@Column(name = "UNIDADE", length = 5)
	private String Unidade;
	
	@Column(name = "INSCRICAO", length = 50)
	private String Inscricao;
	
	@ManyToOne
	@JoinColumn(nullable = true)
	private Contribuinte contribuinte;

	//GETERS E SETERS....
	public String getZona() {
		return Zona;
	}

	public void setZona(String zona) {
		Zona = zona;
	}

	public String getSetor() {
		return Setor;
	}

	public void setSetor(String setor) {
		Setor = setor;
	}

	public String getQuadra() {
		return Quadra;
	}

	public void setQuadra(String quadra) {
		Quadra = quadra;
	}

	public String getLote() {
		return Lote;
	}

	public void setLote(String lote) {
		Lote = lote;
	}

	public String getUnidade() {
		return Unidade;
	}

	public void setUnidade(String unidade) {
		Unidade = unidade;
	}

	public String getInscricao() {
		return Inscricao;
	}

	public void setInscricao(String inscricao) {
		Inscricao = inscricao;
	}

	public Contribuinte getContribuinte() {
		return contribuinte;
	}

	public void setContribuinte(Contribuinte contribuinte) {
		this.contribuinte = contribuinte;
	}

}
