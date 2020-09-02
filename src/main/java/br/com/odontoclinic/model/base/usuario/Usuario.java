package br.com.odontoclinic.model.base.usuario;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.com.odontoclinic.model.base.gestudo.Painel;
import br.com.odontoclinic.model.generic.GenericCadastro;

@SuppressWarnings("serial")
@Entity
public class Usuario extends GenericCadastro  {

	//ESSE CARA USUÁRIO É INDEPENTE AQUI DO CLIENTE..
	//ESTA EXTENDENDO O GENERIC DO CADASTRO PARA APROVEITAR O ATRIBUTO DO CPF EU OUTROS...
	
	//CRUD BÁSICO.... CRIADO... EM 21/05/2017
	//PRÓXIMAS ETAPAS: Organizar melhor a List da DataTable..
	//Criar a View do usuário na coluna "Opções" com os botões 
	
	//AO CRIAR O USUÁRIO O MESMO DEVERÁ SER SALVO COMO INATIVO AUTOMATICAMENTE... POIS NESTE
	//CASO A SENHA AINDA NÃO FOI CRIADA...
	//Criar método para gerar a senha inicial automaticamente...? 
	//Criar algoritmo para forçar a troca da senha no primeiro logon...?
	//Criar método para impedir login ou inativar o usuário em definitivo se errar mais de três vezes a senha..
	//Criar algoritmo para forçar a troca da senha depois de um período X de Dias...
	//Estudar uma forma de o Cod Java analizar os critérios de complexidade... OK!.. via Prime.. o básico!
	//Estudar como seria a conexão para usar o Login do AD Microsoft...
	//View Básica para a troca da Senha.. OK.. Faltam detalhes de amarração dos campos e required! por exemplo.
	
	//O Campo senha Atual não deve aparecer se o usuário não tiver nenhuma senha cadastrada.. OK..!
	//Usar uma senha basica criada automaticamente ao criar o usuário para o primeiro logon..
	//Essa senha basica automatica deve valer por X tempo.. depois não mais...
	//Reset só sob a conta do administrador...
	//Ao fazer o reset a senha volta ao padrão básico e validade por X Tempo...
	
	//Permitir Login apenas de usuários ativos...
	
	//Se a data da criação do cadastro for igual a da criação da senha
	//.... Marcar essa senha como nunca alterada...!
	//Senhas Resetadas ou Não alteradas desde a criação devem ter prazo de validade de X Tempo...
	//IDÉIA DE NÃO PERMITIR A ATIVAÇÃO DE USUÁRIOS SEM SENHA, OU SEJA, SENHA null
	//JÁ IMPLEMENTEI ESSA IDÉIA AO MARCAR NA LIST VIEW BOTÕES QUE SE DESABILITAM SE A SENHA FOR null, por exemplo
	
	@Column (length = 32, nullable = true)
	private String senha;
	
	@Transient
	private String senhaSemCriptografia;
	
	@Transient
	private String novaSenhaSemCripto;
	
	@Transient
	private String novaSenhaSemCriptoContraprova;
	
	//para MARCAÇÃO de perfis.. se for Administrador "A" de for Usuário "U"
	@Column
	private Character tipo;
	
	@Column
	private Boolean ativo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dta_cria_senha")
	private Date DtaCriaSenha;
	
	// INICIO DOS RELACIONAMENTOS DE TABELAS / CLASSES ##################################
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Painel> paineis;
	// FIM DOS RELACIONAMENTOS DE TABELAS / CLASSES ####################################
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenhaSemCriptografia() {
		return senhaSemCriptografia;
	}

	public void setSenhaSemCriptografia(String senhaSemCriptografia) {
		this.senhaSemCriptografia = senhaSemCriptografia;
	}
	
	public String getNovaSenhaSemCripto() {
		return novaSenhaSemCripto;
	}
	
	public void setNovaSenhaSemCripto(String novaSenhaSemCripto) {
		this.novaSenhaSemCripto = novaSenhaSemCripto;
	}
	
	public String getNovaSenhaSemCriptoContraprova() {
		return novaSenhaSemCriptoContraprova;
	}
	
	public void setNovaSenhaSemCriptoContraprova(String novaSenhaSemCriptoContraprova) {
		this.novaSenhaSemCriptoContraprova = novaSenhaSemCriptoContraprova;
	}

	public Character getTipo(Character tipo) {
		return tipo;
	}

	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	public Date getDtaCriaSenha() {
		return DtaCriaSenha;
	}
	
	public void setDtaCriaSenha(Date dtaCriaSenha) {
		DtaCriaSenha = dtaCriaSenha;
	}
	
	//USADO NOS TESTES DA CLASSE Painel p/ ESTUDO GERENCIAL
	public List<Painel> getPaineis() {
		return paineis;
	}
	
	//USADO NOS TESTES DA CLASSE Painel p/ ESTUDO GERENCIAL
	public void setPaineis(List<Painel> paineis) {
		this.paineis = paineis;
	}

	//HASH CODE AND EQUALS FORAM REGEREADOS!! POR CONTA DA INTERAÇÃO COM A CLASSE Painel
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((DtaCriaSenha == null) ? 0 : DtaCriaSenha.hashCode());
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
		result = prime * result + ((novaSenhaSemCripto == null) ? 0 : novaSenhaSemCripto.hashCode());
		result = prime * result
				+ ((novaSenhaSemCriptoContraprova == null) ? 0 : novaSenhaSemCriptoContraprova.hashCode());
		result = prime * result + ((paineis == null) ? 0 : paineis.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((senhaSemCriptografia == null) ? 0 : senhaSemCriptografia.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Usuario other = (Usuario) obj;
		if (DtaCriaSenha == null) {
			if (other.DtaCriaSenha != null)
				return false;
		} else if (!DtaCriaSenha.equals(other.DtaCriaSenha))
			return false;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		if (novaSenhaSemCripto == null) {
			if (other.novaSenhaSemCripto != null)
				return false;
		} else if (!novaSenhaSemCripto.equals(other.novaSenhaSemCripto))
			return false;
		if (novaSenhaSemCriptoContraprova == null) {
			if (other.novaSenhaSemCriptoContraprova != null)
				return false;
		} else if (!novaSenhaSemCriptoContraprova.equals(other.novaSenhaSemCriptoContraprova))
			return false;
		if (paineis == null) {
			if (other.paineis != null)
				return false;
		} else if (!paineis.equals(other.paineis))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (senhaSemCriptografia == null) {
			if (other.senhaSemCriptografia != null)
				return false;
		} else if (!senhaSemCriptografia.equals(other.senhaSemCriptografia))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
	
}
