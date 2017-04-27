package br.com.odontoclinic.controller.endereco;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.odontoclinic.model.base.contratante.Contratante;
import br.com.odontoclinic.model.base.endereco.Endereco;
import br.com.odontoclinic.model.base.referencia.Referencia;
import br.com.odontoclinic.stuff.contratante.ContratanteRN;
import br.com.odontoclinic.stuff.endereco.EnderecoENum;
import br.com.odontoclinic.stuff.endereco.EnderecoRN;
import br.com.odontoclinic.stuff.endereco.TipoEnderecoENum;
import br.com.odontoclinic.stuff.referencia.ReferenciaRN;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EnderecoBean implements Serializable {
	
	private Endereco endereco;
	private List<Endereco> enderecos;

	private List<Contratante> contratantes;
	private List<Contratante> pacientes;
	private List<Referencia> referencias;
	
	private EnderecoENum tipoLogradouro;
	private TipoEnderecoENum tipoDoEndereco;
	
	//########################### Enumerador 1
	public EnderecoENum[] getLabel(){
		return EnderecoENum.values();
	}
	
	public EnderecoENum getTipoLogradouro() {
		return tipoLogradouro;
	}
	
	public void setTipoLogradouro(EnderecoENum tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}
	//################################################################################
	
	//########################### Enumerador 2
	public TipoEnderecoENum[] getLabel2(){
		return TipoEnderecoENum.values();
	}
	
	public TipoEnderecoENum getTipoDoEndereco() {
		return tipoDoEndereco;
	}
	
	public void setTipoDoEndereco(TipoEnderecoENum tipoDoEndereco) {
		this.tipoDoEndereco = tipoDoEndereco;
	}
	//################################################################################
	
	public Endereco getEndereco() {
		if (this.endereco == null) {
			this.endereco = new Endereco();
		}
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	//USADO NO SELECT ONE MENU DA VIEW BASICA DE CRIAÇÃO DE ENDEREÇOS
	public List<Contratante> getContratantes() {
		ContratanteRN contratanteRN = new ContratanteRN();
		if (this.contratantes == null) {
			this.contratantes = contratanteRN.listarApenasContratantes();
		}
		return contratantes;
	}
	
	public void setContratantes(List<Contratante> contratantes) {
		this.contratantes = contratantes;
	}
	
	//USADO NO SELECT ONE MENU DA VIEW BASICA DE CRIAÇÃO DE ENDEREÇOS
	public List<Referencia> getReferencias() {
		ReferenciaRN referenciaRN = new ReferenciaRN();
		if (this.referencias == null) {
			this.referencias = referenciaRN.listagem();
		}
		return referencias;
	}
	
	public void setReferencias(List<Referencia> referencias) {
		this.referencias = referencias;
	}
	
	public List<Contratante> getPacientes() {
		ContratanteRN contratanteRN = new ContratanteRN();
		if (this.pacientes == null) {
			this.pacientes = contratanteRN.listarApenasPacientes();
		}
		return pacientes;
	}
	
	public void setPacientes(List<Contratante> pacientes) {
		this.pacientes = pacientes;
	}
	
	//Criar como padrão para todas as classes
	//O PostConstruct da Listagem dataTable
	@PostConstruct
	public void Listar(){
		
		try {
				EnderecoRN enderecoRN = new EnderecoRN();
				enderecos = enderecoRN.listagem();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar listar Enderecos" + erro);
			erro.printStackTrace();
		}
		
	}
	
	public void novo(){
		
		try {
				this.endereco = new Endereco();
			
				EnderecoRN enderecoRN = new EnderecoRN();
				enderecos = enderecoRN.listagem();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar gerar um novo Endereço" + erro);
			erro.printStackTrace();
		}
		
	}
	
	//#################################### MÉTODOS BASE..

	//###################################################################################################
	//Método utilizado também para editar...
	//NÃO FUNCIONA.. DIZ QUE ESTOU USANDO OBJETOS DIFERENTES NA MESMA SESSÃO...
	public void salvar(){

		EnderecoRN enderecoRN = new EnderecoRN();
		//Isso aqui pesquisa no banco..!
		Endereco enderecoSelecionado = enderecoRN.carregar(this.endereco.getCodigo());

		if (enderecoSelecionado.getContratante() != null) {
			salvarEnderecoContratante();

		} else
			salvarEnderecoReferencia();

	}
	//###################################################################################################
	
	//###################################################################################################
		//Método de estudo para msn de avisos e parada do processamento ao chegar no return..
		public void salvarEnderecoContratante2(){		
			Contratante selectOneMenuContratante = this.endereco.getContratante();
			if (selectOneMenuContratante == null) {
					//Messages.addGlobalError("Selecione a Contratante!!");
					//Messages.addGlobalWarn("Selecione a Contratante!!");
					//Messages.addGlobalInfo("Selecione a Contratante!!");
					Messages.addFlashGlobalWarn("Selecione a Contratante!!");
				
					//Esse return significa pare aqui!!!?
					return;
			} 
				Messages.addGlobalError("Passei por aqui!");			
		}
		//###################################################################################################

	
	public void salvarEnderecoContratante(){
		Contratante selectOneMenuContratante = this.endereco.getContratante();
		
		if (selectOneMenuContratante == null) {
			Messages.addGlobalWarn("Ops!.. Pra qual CONTRATANTE é esse endereço?");
			return;
		} else if (selectOneMenuContratante != null) {
			try {
				EnderecoRN enderecoRN = new EnderecoRN();
				enderecoRN.salvarEndContratante(this.endereco);

				endereco = new Endereco();
				enderecos = enderecoRN.listagem();
				
				Messages.addGlobalInfo("Endereço Salvo com sucesso!");

			} catch (RuntimeException erro) {
				Messages.addGlobalError("Erro ao tentar Salvar um Endereço" + erro);
				erro.printStackTrace();
			}
		}
	}

	public void salvarEnderecoReferencia(){
		Referencia selectOneMenuReferencia = this.endereco.getReferencia();
		
		if (selectOneMenuReferencia == null) {
			Messages.addGlobalWarn("Ops!.. Pra qual REFERÊNCIA é esse endereço?");
			return;
			
		} else if (selectOneMenuReferencia != null) {
			try {
				EnderecoRN enderecoRN = new EnderecoRN();
				enderecoRN.salvarEndReferencia(this.endereco);
				
				endereco = new Endereco();
				enderecos = enderecoRN.listagem();
				
				Messages.addGlobalInfo("Endereço Salvo com sucesso!");
				
			} catch (RuntimeException erro) {
				Messages.addGlobalError("Erro ao tentar Salvar um Endereço" + erro);
				erro.printStackTrace();
			}
		}
	}
	
	public void salvarEnderecoPaciente(){
		Contratante selectOneMenuContratante = this.endereco.getContratante();
		
		if (selectOneMenuContratante == null) {
			Messages.addGlobalWarn("Ops!.. Pra qual PACIENTE é esse endereço?");
			return;
			
		} else if (selectOneMenuContratante != null) {
			try {
				EnderecoRN enderecoRN = new EnderecoRN();
				enderecoRN.salvarEndPaciente(this.endereco);
				
				endereco = new Endereco();
				enderecos = enderecoRN.listagem();
				
				Messages.addGlobalInfo("Endereço Salvo com sucesso!");
				
			} catch (RuntimeException erro) {
				Messages.addGlobalError("Erro ao tentar Salvar um Endereço" + erro);
				erro.printStackTrace();
			}
		}
	}
	
	public void editar(ActionEvent evento){
		this.endereco = (Endereco) evento.getComponent().getAttributes().get("enderecoSelecionado");
	}
	
	public void excluir(ActionEvent evento){
		try {
				this.endereco = (Endereco) evento.getComponent().getAttributes().get("enderecoSelecionado");
				
				EnderecoRN enderecoRN = new EnderecoRN();
				enderecoRN.excluir(endereco);
				
				endereco = new Endereco();
				enderecos = enderecoRN.listagem();
				
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar Excluir um Endereço" + erro);
			erro.printStackTrace();
		}
	}

}
