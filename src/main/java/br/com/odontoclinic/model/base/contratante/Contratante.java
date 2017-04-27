package br.com.odontoclinic.model.base.contratante;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.OrderBy;

import br.com.odontoclinic.model.base.endereco.Endereco;
import br.com.odontoclinic.model.base.referencia.Referencia;
import br.com.odontoclinic.model.generic.GenericCadastro;

@SuppressWarnings("serial")
@Entity
public class Contratante extends GenericCadastro {
	
	//#################### AUTO RELACIONAMENTO NA TABELA DO BD!! ###################################
	@ManyToOne
	@JoinColumn(name = "contratante_pai", nullable = true)
	private Contratante pai;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "contratante_pai", updatable = false)
	@OrderBy(clause = "contratante_status asc")
	private List<Contratante> filhos;
	//#################### AUTO RELACIONAMENTO NA TABELA DO BD!! ###################################
	
	//Criada para saber se o registro exerce função de CONTRATANTE ou somente de PACIENTE..
	// | "co" = CONTRATANTE | "pa" = PACIENTE |
	@Column(name = "camada_funcional", length = 10)
	private String Camada;
	
	@Column(name = "registro_nativo", length = 20)
	private String Nativo;
	
	//Criada para registrar o momento da mudança da função (Camada) de determinado registro
	@Column(name = "dta_muda_camada")
	@Temporal(TemporalType.TIMESTAMP)
	private Date DtaMudaCamada;
	
	@Column(name = "contratante_status", length = 60)
	private String ContratanteStatus; //Vai receber os Valores de um Enum vinculado ao OneSelection
	
	//UMA CONTRATANTE PODE TER OU ACESSAR UMA LISTA DE Referencias
	@OneToMany(mappedBy="contratante", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Referencia> referencias;
	
	//UMA CONTRATANTE PODE TER OU ACESSAR UMA LISTA DE Enderecos
	@OneToMany(mappedBy="contratante", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Endereco> enderecos;
	
	public String getNativo() {
		return Nativo;
	}
	
	public void setNativo(String nativo) {
		Nativo = nativo;
	}

	public String getCamada() {
		return Camada;
	}

	public void setCamada(String camada) {
		Camada = camada;
	}

	public Date getDtaMudaCamada() {
		return DtaMudaCamada;
	}

	public void setDtaMudaCamada(Date dtaMudaCamada) {
		DtaMudaCamada = dtaMudaCamada;
	}

	public List<Contratante> getFilhos() {
		return filhos;
	}

	public void setFilhos(List<Contratante> filhos) {
		this.filhos = filhos;
	}

	public Contratante getPai() {
		return pai;
	}

	public void setPai(Contratante pai) {
		this.pai = pai;
	}

	public String getContratanteStatus() {
		return ContratanteStatus;
	}

	public void setContratanteStatus(String contratanteStatus) {
		ContratanteStatus = contratanteStatus;
	}

	public List<Referencia> getReferencias() {
		return referencias;
	}

	public void setReferencias(List<Referencia> referencias) {
		this.referencias = referencias;
	}
	
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
}
