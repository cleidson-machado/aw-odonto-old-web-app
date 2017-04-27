package br.com.odontoclinic.model.generic;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class GenericCadastro extends GenericPrimaryKey {

	private static final long serialVersionUID = 1L;

	@Column(name = "nome", length = 50)
	private String Nome;
	
	
	@Column(name = "sobre_nome", length = 50)
	private String SobreNome;
	
	
	@Column(name = "num_cnpj", length = 20, nullable = true)
	private String Cnpj;
	
	
	@Column(name = "num_cpf", length = 20, nullable = true)
	private String Cpf;
	
	
	@Column(name = "num_rg", length = 20)
	private String Rg;
	
	
	@Column(name = "fone1", length = 50)
	private String Fone1;
	
	
	@Column(name = "fone2", length = 50)
	private String Fone2;
	
	
	@Column(name = "fone3", length = 50)
	private String Fone3;
	
	
	@Column(name = "email1", length = 50)
	private String Email1;
	
	
	@Column(name = "email2", length = 50)
	private String Email2;
	
	
	@Column(name = "email3" , length = 50)
	private String Email3;
	
	
	@Column(name = "dta_nascimento")
	@Temporal(TemporalType.TIMESTAMP)
	private Date DtaNascimento;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dta_cadastro")
	private Date DtaCadastro;
	
	
	@Column(name = "sexo", length = 20)
	private String Sexo;
	
	
	@Column(name = "est_civil", length = 50)
	private String EstCivil;
	
	//FÍSICA OU JURÍDICA.
	//CRIA UM ALGORITMO QUE FAÇA O SEGUINTE:.. SE TIVER APENAS CPF = PESSOA FÍSICA
	//SE TIVER APENAS CNPJ.. PESSOA JURIDICA
	//SE INFORMAR OS DOIS CONSIDERAR APENAS O CNPJ E MARCAR COMO PESSOA JURIDICA
	//SE NÃO INFORMAR NADA... NÃO SALVAR..
	@Column(name = "tipo_cadastro", length = 100)
	private String Tipo; //Vai receber os Valores de um Enum vinculado ao OneSelection INICIALMENTE

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getSobreNome() {
		return SobreNome;
	}

	public void setSobreNome(String sobreNome) {
		SobreNome = sobreNome;
	}

	public String getCnpj() {
		return Cnpj;
	}

	public void setCnpj(String cnpj) {
		Cnpj = cnpj;
	}

	public String getCpf() {
		return Cpf;
	}

	public void setCpf(String cpf) {
		Cpf = cpf;
	}

	public String getRg() {
		return Rg;
	}

	public void setRg(String rg) {
		Rg = rg;
	}

	public String getFone1() {
		return Fone1;
	}

	public void setFone1(String fone1) {
		Fone1 = fone1;
	}

	public String getFone2() {
		return Fone2;
	}

	public void setFone2(String fone2) {
		Fone2 = fone2;
	}

	public String getFone3() {
		return Fone3;
	}

	public void setFone3(String fone3) {
		Fone3 = fone3;
	}

	public String getEmail1() {
		return Email1;
	}

	public void setEmail1(String email1) {
		Email1 = email1;
	}

	public String getEmail2() {
		return Email2;
	}

	public void setEmail2(String email2) {
		Email2 = email2;
	}

	public String getEmail3() {
		return Email3;
	}

	public void setEmail3(String email3) {
		Email3 = email3;
	}

	public Date getDtaNascimento() {
		return DtaNascimento;
	}

	public void setDtaNascimento(Date dtaNascimento) {
		DtaNascimento = dtaNascimento;
	}

	public Date getDtaCadastro() {
		return DtaCadastro;
	}

	public void setDtaCadastro(Date dtaCadastro) {
		DtaCadastro = dtaCadastro;
	}

	public String getSexo() {
		return Sexo;
	}

	public void setSexo(String sexo) {
		Sexo = sexo;
	}

	public String getEstCivil() {
		return EstCivil;
	}

	public void setEstCivil(String estCivil) {
		EstCivil = estCivil;
	}
	
	public String getTipo() {
		return Tipo;
	}
	
	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((Cnpj == null) ? 0 : Cnpj.hashCode());
		result = prime * result + ((Cpf == null) ? 0 : Cpf.hashCode());
		result = prime * result + ((DtaCadastro == null) ? 0 : DtaCadastro.hashCode());
		result = prime * result + ((DtaNascimento == null) ? 0 : DtaNascimento.hashCode());
		result = prime * result + ((Email1 == null) ? 0 : Email1.hashCode());
		result = prime * result + ((Email2 == null) ? 0 : Email2.hashCode());
		result = prime * result + ((Email3 == null) ? 0 : Email3.hashCode());
		result = prime * result + ((EstCivil == null) ? 0 : EstCivil.hashCode());
		result = prime * result + ((Fone1 == null) ? 0 : Fone1.hashCode());
		result = prime * result + ((Fone2 == null) ? 0 : Fone2.hashCode());
		result = prime * result + ((Fone3 == null) ? 0 : Fone3.hashCode());
		result = prime * result + ((Nome == null) ? 0 : Nome.hashCode());
		result = prime * result + ((Rg == null) ? 0 : Rg.hashCode());
		result = prime * result + ((Sexo == null) ? 0 : Sexo.hashCode());
		result = prime * result + ((SobreNome == null) ? 0 : SobreNome.hashCode());
		result = prime * result + ((Tipo == null) ? 0 : Tipo.hashCode());
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
		GenericCadastro other = (GenericCadastro) obj;
		if (Cnpj == null) {
			if (other.Cnpj != null)
				return false;
		} else if (!Cnpj.equals(other.Cnpj))
			return false;
		if (Cpf == null) {
			if (other.Cpf != null)
				return false;
		} else if (!Cpf.equals(other.Cpf))
			return false;
		if (DtaCadastro == null) {
			if (other.DtaCadastro != null)
				return false;
		} else if (!DtaCadastro.equals(other.DtaCadastro))
			return false;
		if (DtaNascimento == null) {
			if (other.DtaNascimento != null)
				return false;
		} else if (!DtaNascimento.equals(other.DtaNascimento))
			return false;
		if (Email1 == null) {
			if (other.Email1 != null)
				return false;
		} else if (!Email1.equals(other.Email1))
			return false;
		if (Email2 == null) {
			if (other.Email2 != null)
				return false;
		} else if (!Email2.equals(other.Email2))
			return false;
		if (Email3 == null) {
			if (other.Email3 != null)
				return false;
		} else if (!Email3.equals(other.Email3))
			return false;
		if (EstCivil == null) {
			if (other.EstCivil != null)
				return false;
		} else if (!EstCivil.equals(other.EstCivil))
			return false;
		if (Fone1 == null) {
			if (other.Fone1 != null)
				return false;
		} else if (!Fone1.equals(other.Fone1))
			return false;
		if (Fone2 == null) {
			if (other.Fone2 != null)
				return false;
		} else if (!Fone2.equals(other.Fone2))
			return false;
		if (Fone3 == null) {
			if (other.Fone3 != null)
				return false;
		} else if (!Fone3.equals(other.Fone3))
			return false;
		if (Nome == null) {
			if (other.Nome != null)
				return false;
		} else if (!Nome.equals(other.Nome))
			return false;
		if (Rg == null) {
			if (other.Rg != null)
				return false;
		} else if (!Rg.equals(other.Rg))
			return false;
		if (Sexo == null) {
			if (other.Sexo != null)
				return false;
		} else if (!Sexo.equals(other.Sexo))
			return false;
		if (SobreNome == null) {
			if (other.SobreNome != null)
				return false;
		} else if (!SobreNome.equals(other.SobreNome))
			return false;
		if (Tipo == null) {
			if (other.Tipo != null)
				return false;
		} else if (!Tipo.equals(other.Tipo))
			return false;
		return true;
	}
	
	

}
