package br.com.odontoclinic.model.base.referencia;

import java.util.List;

import javax.persistence.*;

import br.com.odontoclinic.model.base.contratante.Contratante;
import br.com.odontoclinic.model.base.endereco.Endereco;
import br.com.odontoclinic.model.generic.GenericCadastro;

@SuppressWarnings("serial")
@Entity
public class Referencia extends GenericCadastro {

	@Column(name="referencia_status")
	private String ReferenciaStatus;
	
	@Column(name="referencia_tipo")
	private String ReferenciaTipo;
	
	//VAI criar aqui a Coluna com a FK..
	//Muitas Referencias para uma Contratante...
	@ManyToOne
	@JoinColumn(nullable = false)
	private Contratante contratante;
	
	//UMA REFERENCIA PODE TER OU ACESSAR UMA LISTA DE Enderecos.. para ela mesma...
	@OneToMany(mappedBy="referencia", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Endereco> enderecos;

	public String getReferenciaStatus() {
		return ReferenciaStatus;
	}

	public void setReferenciaStatus(String referenciaStatus) {
		ReferenciaStatus = referenciaStatus;
	}

	public String getReferenciaTipo() {
		return ReferenciaTipo;
	}

	public void setReferenciaTipo(String referenciaTipo) {
		ReferenciaTipo = referenciaTipo;
	}

	public Contratante getContratante() {
		return contratante;
	}

	public void setContratante(Contratante contratante) {
		this.contratante = contratante;
	}
	
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
}
