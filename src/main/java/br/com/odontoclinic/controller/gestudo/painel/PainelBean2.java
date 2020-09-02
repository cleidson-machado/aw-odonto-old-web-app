package br.com.odontoclinic.controller.gestudo.painel;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.odontoclinic.model.base.gestudo.Cliente;
import br.com.odontoclinic.model.base.gestudo.Painel;
import br.com.odontoclinic.model.base.usuario.Usuario;
import br.com.odontoclinic.stuff.gestudo.cliente.ClienteRN;
import br.com.odontoclinic.stuff.gestudo.painel.PainelRN;
import br.com.odontoclinic.stuff.usuario.UsuarioRN;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PainelBean2 implements Serializable {
	
	private Painel painel;
	
	private List<Painel> paineisOriginal;

	private List<Painel> paineisNotOriginal;
	
	private List<Painel> paineisTheFirstNotOriginal;
	
	//SELECT ONE MENU
	private List<Cliente> clientes;
	
	//SELECT ONE MENU
	private List<Usuario> usuarios;
	
	public Painel getPainel() {
		return painel;
	}

	public void setPainel(Painel painel) {
		this.painel = painel;
	}
	
	//USADO DIRETAMENMTE NO LISTA DO DATATABLE PRINCIPAL NO LIST DESSE PAINEL
	public List<Painel> getPaineisOriginal() {
		PainelRN painelRN = new PainelRN();
		if (paineisOriginal == null) {
			paineisOriginal = painelRN.listOriginalIn();
		}
		return paineisOriginal;
	}
	
	public void setPaineisOriginal(List<Painel> paineisOriginal) {
		this.paineisOriginal = paineisOriginal;
	}
	
	//SEM A FILTRAGEM PARA PAINEIS ORIGINAIS.. USADO NA COLUNA FG DO PAINEL DATA TABLE INDEX
	public List<Painel> getPaineisNotOriginal() {
		PainelRN painelRN = new PainelRN();
		if (paineisNotOriginal == null) {
			paineisNotOriginal = painelRN.listAllNotOriginalIn();
		}
		return paineisNotOriginal;
	}
	
	public void setPaineisNotOriginal(List<Painel> paineisNotOriginal) {
		this.paineisNotOriginal = paineisNotOriginal;
	}
	
	//USADO NO LISTDIALOG SECUNDÁRIO INICIADO DO PAINEL
	public List<Painel> getPaineisTheFirstNotOriginal() {
		PainelRN painelRN = new PainelRN();
		if (paineisTheFirstNotOriginal == null) {
			paineisTheFirstNotOriginal = painelRN.listTheFirstOneNotOriginalIn();
		}
		return paineisTheFirstNotOriginal;
	}
	
	public void setPaineisTheFirstNotOriginal(List<Painel> paineisTheFirstNotOriginal) {
		this.paineisTheFirstNotOriginal = paineisTheFirstNotOriginal;
	}

	//USADO NO SELECT ONE MENU DO CREATE TICKET E DO PAINEL
	public List<Cliente> getClientes() {
		ClienteRN clienteRN = new ClienteRN();
		if (clientes == null) {
			clientes = clienteRN.listagem();
		}
		return clientes;
	}
	
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	//USADO NO SELECT ONE MENU DO PAINEL
	public List<Usuario> getUsuarios() {
		UsuarioRN usuarioRN = new UsuarioRN();
		if (usuarios == null) {
			usuarios = usuarioRN.listagem();
		}
		return usuarios;
	}
	
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	//METODOS PADRÃO
	//O PADRÃO É LISTAR TODOS QUE SÃO APENAS ORIGINAIS...
	@PostConstruct
	public void listar() {
		try {
			PainelRN painelRN = new PainelRN();
			this.paineisOriginal = painelRN.listOriginalIn();
			
		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao tentar Listar o Painel" + erro);
			erro.printStackTrace();
		}
	}
	
	//USADO NO BTN LISTAR TODOS DO PAINEL2
	public void listarAllData() {
		try {
			PainelRN painelRN = new PainelRN();
			this.paineisOriginal = painelRN.listagem();
			
		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao tentar Listar o Painel" + erro);
			erro.printStackTrace();
		}
	}
	
	//USADO NO BTN TICKETS DO PAINEL2
	public void listarAllDataTiket() {
		try {
			PainelRN painelRN = new PainelRN();
			this.paineisOriginal = painelRN.listAllNotOriginalIn();
			
		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao tentar Listar o Painel" + erro);
			erro.printStackTrace();
		}
	}
	
	//USADO NO BTN ASSUMIDOS DO PAINEL2
		public void listarDataTiketAssumido() {
			try {
				PainelRN painelRN = new PainelRN();
				this.paineisOriginal = painelRN.listAllTicketsAssumidos();
				
			} catch (Exception erro) {
				Messages.addGlobalError("Erro ao tentar Listar o Painel" + erro);
				erro.printStackTrace();
			}
		}
	
	public void novo() {
		try {
			this.painel = new Painel();
			listar();

		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao tentar Criar Item de Painel" + erro);
			erro.printStackTrace();
		}
	}
	
	public void salvar() {
		try {
			PainelRN painelRN = new PainelRN();
			
			//TESTES SALVAR PAINEL IMBUTINDO PRÉ-INFORMAÇÕES PADRÃO
			painelRN.salvar(this.painel);
			this.painel = new Painel();
			listar();

		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao tentar Salvar Item o Painel" + erro);
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			this.painel = (Painel) evento.getComponent().getAttributes().get("painelSelecionado");
			
			PainelRN painelRN = new PainelRN();
			painelRN.excluir(this.painel);
			listar();

		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao tentar Excluir Item de Painel" + erro);
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento) {
		this.painel = (Painel) evento.getComponent().getAttributes().get("painelSelecionado");
	}
	
	
	//METODOS PERSONALIZADOS
	//################################################################################################################################################

	public void salvarEditando() {
		try {
			PainelRN painelRN = new PainelRN();
			painelRN.editar(this.painel);
			
			this.painel = new Painel();
			listar();

		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao tentar Salvar Editando Item o Painel" + erro);
			erro.printStackTrace();
		}
	}

	//TESTES AFINS... VERIFICAR
	public void updateTicketFromPainel(ActionEvent evento) {
		try {
			//esse já vem do editar usado mo botão FG na List do Painel
			//this.painel = (Painel) evento.getComponent().getAttributes().get("painelSelecionado");
			
			//PainelRN painelRN = new PainelRN();
			//painelRN.editarPainelTK(this.painel);
			
			Messages.addFlashGlobalInfo("Novo Atendimento Assumido com Sucesso!" + this.painel.getCodigo());
		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao Assumir Novo Ticket" + erro);
			erro.printStackTrace();
		}
	
	}
	
	//TESTES AFINS... VERIFICAR PARA EXCLUIR DEPOIS!
	public void filaGeralDialog(ActionEvent evento) {
		this.painel = (Painel) evento.getComponent().getAttributes().get("painelSelecionado");
	}

	//APENAS PARA USO DO REFRESH VIA PRIMEFACE COMPONENT
	public void atualizador() {
		try {
			
			PainelRN painelRN = new PainelRN();
			this.paineisOriginal = painelRN.listOriginalIn();
			
		} catch (Exception erro) {
			Messages.addGlobalError("Erro REFRESH do Painel" + erro);
			erro.printStackTrace();
		}
	}

}