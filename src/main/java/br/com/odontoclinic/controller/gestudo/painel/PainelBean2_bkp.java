package br.com.odontoclinic.controller.gestudo.painel;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.odontoclinic.model.base.gestudo.Painel;
import br.com.odontoclinic.stuff.gestudo.painel.PainelRN;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PainelBean2_bkp implements Serializable {
	
	private Painel painel;
	private List<Painel> paineis;
	
	public Painel getPainel() {
		return painel;
	}

	public void setPainel(Painel painel) {
		this.painel = painel;
	}

	public List<Painel> getPaineis() {
		PainelRN painelRN = new PainelRN();
		if (paineis == null) {
			paineis = painelRN.listagem();
		}
		return paineis;
	}

	public void setPaineis(List<Painel> paineis) {
		this.paineis = paineis;
	}

	//METODOS PADRÃO
	@PostConstruct
	public void listar() {
		try {
			PainelRN painelRN = new PainelRN();
			this.paineis = painelRN.listagem();
			
		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao tentar Listar o Painel" + erro);
			erro.printStackTrace();
		}
	}
	
	public void novo() {
		try {
			this.painel = new Painel();
			
			PainelRN painelRN = new PainelRN();
			this.paineis = painelRN.listagem();

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
			this.paineis = painelRN.listagem();

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
			
			this.paineis = painelRN.listagem();

		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao tentar Excluir Item de Painel" + erro);
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento) {
		this.painel = (Painel) evento.getComponent().getAttributes().get("painelSelecionado");
	}
	
	//METODOS PERSONALIZADOS
	
	public void salvarEditando() {
		try {
			PainelRN painelRN = new PainelRN();
			painelRN.editar(this.painel);
			
			this.painel = new Painel();
			this.paineis = painelRN.listagem();

		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao tentar Salvar Editando Item o Painel" + erro);
			erro.printStackTrace();
		}
	}
}
