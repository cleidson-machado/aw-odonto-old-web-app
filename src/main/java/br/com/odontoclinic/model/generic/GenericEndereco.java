package br.com.odontoclinic.model.generic;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class GenericEndereco extends GenericPrimaryKey {

	private static final long serialVersionUID = 1L;

	//NOME DO LOGRADOURO como: sinônimo de nome da Rua, Avenida, Travessa..
	@Column(length = 80)
	private String logradouro;
	
	//Tipo desse Logradouro Rua, Avenida, Travessa, Zona Rural
	@Column(length = 30)
	private String tipoLogradouro;
	
	//SE NÃO INFORMADO PREENCHER AUTOMATICAMENTE COM S/N
	//TRABALHAR ESSE TIPO DE CAMPO COMO STRING...
	@Column(length = 20)
	private String numImovelLote;
	
	@Column(length = 50)
	private String bairroDistrito;
	
	@Column(length = 80)
	private String complemento;
	
	@Column(length = 20)
	private String cepPostal;
	
	//SE É RESIDÊNCIAL OU COMERCIAL
	@Column(length = 20)
	private String tipoEnd;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getNumImovelLote() {
		return numImovelLote;
	}
	
	public void setNumImovelLote(String numImovelLote) {
		this.numImovelLote = numImovelLote;
	}

	public String getBairroDistrito() {
		return bairroDistrito;
	}

	public void setBairroDistrito(String bairroDistrito) {
		this.bairroDistrito = bairroDistrito;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCepPostal() {
		return cepPostal;
	}

	public void setCepPostal(String cepPostal) {
		this.cepPostal = cepPostal;
	}

	public String getTipoEnd() {
		return tipoEnd;
	}

	public void setTipoEnd(String tipoEnd) {
		this.tipoEnd = tipoEnd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((bairroDistrito == null) ? 0 : bairroDistrito.hashCode());
		result = prime * result + ((cepPostal == null) ? 0 : cepPostal.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
		result = prime * result + ((numImovelLote == null) ? 0 : numImovelLote.hashCode());
		result = prime * result + ((tipoEnd == null) ? 0 : tipoEnd.hashCode());
		result = prime * result + ((tipoLogradouro == null) ? 0 : tipoLogradouro.hashCode());
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
		GenericEndereco other = (GenericEndereco) obj;
		if (bairroDistrito == null) {
			if (other.bairroDistrito != null)
				return false;
		} else if (!bairroDistrito.equals(other.bairroDistrito))
			return false;
		if (cepPostal == null) {
			if (other.cepPostal != null)
				return false;
		} else if (!cepPostal.equals(other.cepPostal))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (logradouro == null) {
			if (other.logradouro != null)
				return false;
		} else if (!logradouro.equals(other.logradouro))
			return false;
		if (numImovelLote == null) {
			if (other.numImovelLote != null)
				return false;
		} else if (!numImovelLote.equals(other.numImovelLote))
			return false;
		if (tipoEnd == null) {
			if (other.tipoEnd != null)
				return false;
		} else if (!tipoEnd.equals(other.tipoEnd))
			return false;
		if (tipoLogradouro == null) {
			if (other.tipoLogradouro != null)
				return false;
		} else if (!tipoLogradouro.equals(other.tipoLogradouro))
			return false;
		return true;
	}
	
}
