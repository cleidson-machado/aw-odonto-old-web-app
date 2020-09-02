package br.com.odontoclinic.model.base.gestudo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import br.com.odontoclinic.model.generic.GenericPrimaryKey;

@SuppressWarnings("serial")
@Entity
public class Assunto extends GenericPrimaryKey {
	
	@Column(name = "txt_titulo")
	private String Titulo;
	
	@Column(name = "nome_de_grupo")
	private String NomeDeGrupo;
	
	@Column(name = "txt_descricao")
	private String Descricao;
	
	@Column(name = "num_peso")
	private int Peso;

	//INICIO DOS RELACIONAMENTOS DE TABELAS / CLASSES
	
	//CHAMADA DE RETORNO DO RELACIONAMENTO PARA CLASSE/TABELA Painel
	@OneToMany(mappedBy="assunto", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Painel> paineis;

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getNomeDeGrupo() {
		return NomeDeGrupo;
	}

	public void setNomeDeGrupo(String nomeDeGrupo) {
		NomeDeGrupo = nomeDeGrupo;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public int getPeso() {
		return Peso;
	}

	public void setPeso(int peso) {
		Peso = peso;
	}

	public List<Painel> getPaineis() {
		return paineis;
	}

	public void setPaineis(List<Painel> paineis) {
		this.paineis = paineis;
	}
	
}
