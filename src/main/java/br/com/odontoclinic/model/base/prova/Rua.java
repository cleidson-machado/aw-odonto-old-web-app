package br.com.odontoclinic.model.base.prova;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.odontoclinic.model.generic.GenericEndereco;

@SuppressWarnings("serial")
@Entity
public class Rua extends GenericEndereco {
		
	@Column(name = "TIPO", length = 10)
	private String TipoRua;
	
	@Column(name = "NOME", length = 50)
	private String NomeRua;
	
	@Column(name = "DATA_CADASTRO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date DtaCadastro;

	//USANDO SOMENTE GETERS E SETERS...
	public String getTipoRua() {
		return TipoRua;
	}

	public void setTipoRua(String tipoRua) {
		TipoRua = tipoRua;
	}

	public String getNomeRua() {
		return NomeRua;
	}

	public void setNomeRua(String nomeRua) {
		NomeRua = nomeRua;
	}

	public Date getDtaCadastro() {
		return DtaCadastro;
	}

	public void setDtaCadastro(Date dtaCadastro) {
		DtaCadastro = dtaCadastro;
	}

}
