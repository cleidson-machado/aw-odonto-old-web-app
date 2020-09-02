package br.com.odontoclinic.model.base.prova;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import br.com.odontoclinic.model.generic.GenericCadastro;

@SuppressWarnings("serial")
@Entity
public class Contribuinte extends GenericCadastro {
	
	@Transient
	private int contaQtd;
	
	//EXTENDE DE GENERIC CADASTRO OU SEJA JÁ POSSUI NOME E CPF
	@Column(name = "NUMERO")
	private int NumContribuinte;
	
	@Column(name = "QTDE_IMOVEL")
	private int QtdImovel;
	
	//FK NA TABELA REFERENTE A ESTA CLASSE...
	@ManyToOne
	@JoinColumn(nullable = true)
	private Rua rua;

	//GETERS E SETERS....
	public int getNumContribuinte() {
		return NumContribuinte;
	}

	public void setNumContribuinte(int numContribuinte) {
		NumContribuinte = numContribuinte;
	}

	public int getQtdImovel() {
		return QtdImovel;
	}

	public void setQtdImovel(int qtdImovel) {
		QtdImovel = qtdImovel;
	}

	public Rua getRua() {
		return rua;
	}

	public void setRua(Rua rua) {
		this.rua = rua;
	}
	
	//TESTES!##################################
	public int getContaQtd() {
		int xQtd;
		
		xQtd = 234;
		
		contaQtd = xQtd;
		
		return contaQtd;
	}
	
	public void setContaQtd(int contaQtd) {
		this.contaQtd = contaQtd;
	}
	//FIM TESTES!##################################

}
