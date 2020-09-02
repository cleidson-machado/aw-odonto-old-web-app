package br.com.odontoclinic.controller.rua;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.odontoclinic.model.base.prova.Contribuinte;
import br.com.odontoclinic.model.base.prova.Rua;
import br.com.odontoclinic.stuff.prova.contribuinte.ContribuinteRN;
import br.com.odontoclinic.stuff.prova.rua.RuaRN;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class RuaBean implements Serializable {
	
	private Rua rua;
	private List<Rua> ruas;
	private List<Contribuinte> contribuintes;
	
	public Rua getRua() {
		return rua;
	}
	
	public void setRua(Rua rua) {
		this.rua = rua;
	}
	
	public List<Rua> getRuas() {
		RuaRN ruaRN = new RuaRN();
		if (ruas == null) {
			ruas = ruaRN.listagem();
		}
		return ruas;
	}
	
	public void setRuas(List<Rua> ruas) {
		this.ruas = ruas;
	}

	public List<Contribuinte> getContribuintes() {
		ContribuinteRN contribuinteRN = new ContribuinteRN();
		if (contribuintes == null) {
			contribuintes = contribuinteRN.listagem();
		}
		return contribuintes;
	}

	public void setContribuintes(List<Contribuinte> contribuintes) {
		this.contribuintes = contribuintes;
	}
	
	@PostConstruct
	public void listar() {
		try {
			RuaRN ruaRN = new RuaRN();
			this.ruas = ruaRN.listagem();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar listar uma Rua" + erro);
			erro.printStackTrace();
		}

	}
	
	public void novo() {
		try {
			this.rua = new Rua();
			
			RuaRN ruaRN = new RuaRN();
			this.ruas = ruaRN.listagem();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao gerar uma nova Rua" + erro);
			erro.printStackTrace();
		}
	}
	
	public void salvar() {
		try {
			RuaRN ruaRN = new RuaRN();
			ruaRN.salvar(this.rua);
			
			this.rua = new Rua();
			this.ruas = ruaRN.listagem();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar salvar a Rua" + erro);
			erro.printStackTrace();
		}
	}
	
	public void salvarEditando() {
		try {
			RuaRN ruaRN = new RuaRN();
			ruaRN.editar(this.rua);
			
			this.rua = new Rua();
			this.ruas = ruaRN.listagem();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar salvar a Rua" + erro);
			erro.printStackTrace();
		}
	}

	
	public void excluir(ActionEvent evento) {
		try {
			this.rua = (Rua) evento.getComponent().getAttributes().get("ruaSelecionada");
			
			RuaRN ruaRN = new RuaRN();
			ruaRN.excluir(this.rua);
			
			this.ruas = ruaRN.listagem();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar remover a Rua");
			erro.printStackTrace();
		}
	}


	public void editar(ActionEvent evento) {
		this.rua = (Rua) evento.getComponent().getAttributes().get("ruaSelecionada");
	}

	//PERAI!!!!
	public void ruasPorContribuinte(ActionEvent evento) {
		this.rua = (Rua) evento.getComponent().getAttributes().get("ruaSelecionada");
		
		ContribuinteRN contribuinteRN = new ContribuinteRN();
		contribuintes = contribuinteRN.listagemRuasPorContribuinte(rua.getCodigo());
	}

}
