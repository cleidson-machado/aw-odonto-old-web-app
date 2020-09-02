package br.com.odontoclinic.controller.contribuinte;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.odontoclinic.model.base.prova.Contribuinte;
import br.com.odontoclinic.model.base.prova.Imovel;
import br.com.odontoclinic.model.base.prova.Rua;
import br.com.odontoclinic.stuff.prova.contribuinte.ContribuinteRN;
import br.com.odontoclinic.stuff.prova.imovel.ImovelRN;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ContribuinteBean implements Serializable {
	
	private Contribuinte contribuinte;
	private List<Contribuinte> contribuintes;
	private List<Imovel> imoveis;
	
	//É O CONTRIBUINTE DE CONHECE A RUA..
	private Rua rua;
	private List<Rua> ruas;
	
	public Contribuinte getContribuinte() {
		if (this.contribuinte == null) {
			this.contribuinte = new Contribuinte();
		}
		return contribuinte;
	}
	
	public void setContribuinte(Contribuinte contribuinte) {
		this.contribuinte = contribuinte;
	}
	
	public List<Contribuinte> getContribuintes() {
		ContribuinteRN contribuinteRN = new ContribuinteRN();
		if (this.contribuinte == null) {
			this.contribuintes = contribuinteRN.listagem();
		}
		return contribuintes;
	}
	
	public void setContribuintes(List<Contribuinte> contribuintes) {
		this.contribuintes = contribuintes;
	}
	
	public Rua getRua() {
		return rua;
	}
	
	public void setRua(Rua rua) {
		this.rua = rua;
	}
	
	public List<Rua> getRuas() {
		return ruas;
	}
	
	public void setRuas(List<Rua> ruas) {
		this.ruas = ruas;
	}
	
	public List<Imovel> getImoveis() {
		ImovelRN imovelRN = new ImovelRN();
		if (imoveis == null) {
			imoveis = imovelRN.listagem();
		}
		return imoveis;
	}
	
	public void setImoveis(List<Imovel> imoveis) {
		this.imoveis = imoveis;
	}
	
	@PostConstruct
	public void listar() {
		try {
			ContribuinteRN contribuinteRN = new ContribuinteRN();
			this.contribuintes = contribuinteRN.listagem();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar listar um Contribuinte" + erro);
			erro.printStackTrace();
		}

	}
	
	public void novo() {
		try {
			this.contribuinte = new Contribuinte();
			
			ContribuinteRN contribuinteRN = new ContribuinteRN();
			this.contribuintes = contribuinteRN.listagem();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao gerar um novo Contribuinte" + erro);
			erro.printStackTrace();
		}
	}
	
	public void salvar() {
		try {
			ContribuinteRN contribuinteRN = new ContribuinteRN();
			contribuinteRN.salvar(this.contribuinte);
			
			this.contribuinte = new Contribuinte();
			this.contribuintes = contribuinteRN.listagem();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar salvar o Contribuinte" + erro);
			erro.printStackTrace();
		}
	}


	public void excluir(ActionEvent evento) {
		try {
			this.contribuinte = (Contribuinte) evento.getComponent().getAttributes().get("contribuinteSelecionado");
			
			ContribuinteRN contribuinteRN = new ContribuinteRN();
			contribuinteRN.excluir(this.contribuinte);
			
			this.contribuinte = new Contribuinte();
			this.contribuintes = contribuinteRN.listagem();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar remover o Contribuinte");
			erro.printStackTrace();
		}
	}


	public void editar(ActionEvent evento) {
		this.contribuinte = (Contribuinte) evento.getComponent().getAttributes().get("contribuinteSelecionado");
	}


	//para salvar/editar CONTRIBUINTE passando o ID da RUA
	//PASSADO AQUI VIA COMBO...
	public void editarSalvarContribuinteRua () {
		Rua selectOneMenuRua = this.contribuinte.getRua();
		
		if (selectOneMenuRua == null) {
			Messages.addGlobalWarn("Ops!... QUAL A RUA DESSE CONTRIBUINTE?");
				ContribuinteRN contribuinteRN = new ContribuinteRN();
				this.contribuintes = contribuinteRN.listagem();	
			
			   //STOP ALL HERE!
               return;
		
		} else if (selectOneMenuRua != null) {
			
			try {
				ContribuinteRN contribuinteRN = new ContribuinteRN();
				contribuinteRN.editar(this.contribuinte);
				
				this.contribuinte = new Contribuinte();
				this.contribuintes = contribuinteRN.listagem();
				
			} catch (RuntimeException erro) {
				Messages.addGlobalError("Erro ao tentar Salvar um CONTRIBUINTE" + erro);
				erro.printStackTrace();
			}
		}
	}
	
	//PERAI!!!!
	public void imoveisPorContribuinte (ActionEvent evento) {
		this.contribuinte = (Contribuinte) evento.getComponent().getAttributes().get("contribuinteSelecionado");
		
		ImovelRN imovelRN = new ImovelRN();
		imoveis = imovelRN.listagemImoveisPorContribuinte(contribuinte.getCodigo());
		
	}

}
