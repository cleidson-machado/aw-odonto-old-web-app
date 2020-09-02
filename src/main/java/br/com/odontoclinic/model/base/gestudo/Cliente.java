package br.com.odontoclinic.model.base.gestudo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import br.com.odontoclinic.model.generic.GenericCadastro;

@SuppressWarnings("serial")
@Entity
public class Cliente extends GenericCadastro {
	
	@Column(name = "num_cliente", length = 20)
	private String NumClienteLegacy;

	//INICIO DOS RELACIONAMENTOS DE TABELAS / CLASSES

	//CHAMADA DE RETORNO DO RELACIONAMENTO PARA CLASSE/TABELA Painel...
	//UMA ENTRADA DE CLIENTE PODE TER OU ACESSAR UMA LISTA DE PAINEIS.. para ELA mesma...
	@OneToMany(mappedBy= "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Painel> paineis;
	
	public String getNumClienteLegacy() {
		return NumClienteLegacy;
	}
	
	public void setNumClienteLegacy(String numClienteLegacy) {
		NumClienteLegacy = numClienteLegacy;
	}

	public List<Painel> getPaineis() {
		return paineis;
	}


	public void setPaineis(List<Painel> paineis) {
		this.paineis = paineis;
	}

}
