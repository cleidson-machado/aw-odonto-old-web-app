package br.com.odontoclinic.model.base.gestudo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.odontoclinic.model.generic.GenericPrimaryKey;

@SuppressWarnings("serial")
@Entity
public class Historico extends GenericPrimaryKey {
	
	
	@Column(name = "txt_titulo")
	private String Titulo;
	
	
	@Column(name = "txt_descricao")
	private String Descricao;
	
	
	//INICIO DOS RELACIONAMENTOS DE TABELAS / CLASSES
	
	//FK --- AQUI!!
	//MUITOS ITENS DE HISTÓRICO PARA UM LANÇAMENTO DE PAINEL....
	@ManyToOne
	@JoinColumn(nullable = true)
	private Painel painel;

	//FINAL DOS RELACIONAMENTOS DE TABELAS / CLASSES

	public String getTitulo() {
		return Titulo;
	}


	public void setTitulo(String titulo) {
		Titulo = titulo;
	}


	public String getDescricao() {
		return Descricao;
	}


	public void setDescricao(String descricao) {
		Descricao = descricao;
	}


	public Painel getPainel() {
		return painel;
	}


	public void setPainel(Painel painel) {
		this.painel = painel;
	}

}
