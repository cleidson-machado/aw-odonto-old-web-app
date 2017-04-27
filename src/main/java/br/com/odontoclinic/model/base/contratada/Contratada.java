package br.com.odontoclinic.model.base.contratada;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.odontoclinic.model.generic.GenericCadastro;


@SuppressWarnings("serial")
@Entity
public class Contratada extends GenericCadastro {
	
	//ESSA CLASSE PODE REPRESENTAR UM DENTISTA INDIVIDUAL EM UMA CLÍNICA, POR EXEMPLO...
	//OU UMA UNIDADE DE DETERMINDA REDE DE CONSULTÓRIOS...

	@Column(name = "inscricao_estadual", length = 60)
	private String inscricaoEstadual;
	
	@Column(name = "nome_unidade", length = 60)
	private String nomeUnidade;
	
	@Column(name = "numero_unidade", length = 60)
	private int numUnidade;
	
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	
	public String getNomeUnidade() {
		return nomeUnidade;
	}
	
	public void setNomeUnidade(String nomeUnidade) {
		this.nomeUnidade = nomeUnidade;
	}
	
	public int getNumUnidade() {
		return numUnidade;
	}
	
	public void setNumUnidade(int numUnidade) {
		this.numUnidade = numUnidade;
	}

}
