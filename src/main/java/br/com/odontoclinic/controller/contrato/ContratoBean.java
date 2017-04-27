package br.com.odontoclinic.controller.contrato;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.odontoclinic.model.base.contratada.Contratada;
import br.com.odontoclinic.model.base.contratante.Contratante;
import br.com.odontoclinic.model.base.contrato.Contrato;
import br.com.odontoclinic.stuff.contratada.ContratadaRN;
import br.com.odontoclinic.stuff.contratante.ContratanteRN;
import br.com.odontoclinic.stuff.contrato.ContratoRN;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ContratoBean implements Serializable {
	
	//OK verificado!
	
	private Contrato contrato;
	private List<Contrato> contratos;

	private List<Contratante> contratantes;
	private List<Contratada> contratadas;
	
	public Contrato getContrato() {
		return contrato;
	}
	
	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}
	
	public List<Contrato> getContratos() {
		return contratos;
	}
	
	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}
	
	//USADO NO SELECT ONE MENU
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
	
	//USADO NO SELECT ONE MENU
	public List<Contratada> getContratadas() {
		ContratadaRN contratadaRN = new ContratadaRN();
		if (this.contratadas == null) {
			this.contratadas = contratadaRN.listagem();
		}
		return contratadas;
	}
	
	public void setContratadas(List<Contratada> contratadas) {
		this.contratadas = contratadas;
	}
	
	@PostConstruct
	public void listar(){
		try {
			ContratoRN contratoRN = new ContratoRN();
			contratos = contratoRN.listagem();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar listar um Contrato" + erro);
			erro.printStackTrace();
		}
	}
	
	public void novo(){
		try {
			this.contrato = new Contrato();
			
			ContratoRN contratoRN = new ContratoRN();
			this.contratos = contratoRN.listagem();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao gerar um novo Contrato" + erro);
			erro.printStackTrace();
		}
	}
	
	public void salvar(){
		try {
			ContratoRN contratoRN = new ContratoRN();
			contratoRN.salvar(this.contrato);
			
			this.contrato = new Contrato();
			this.contratos = contratoRN.listagem();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar salvar o Contrato" + erro);
			erro.printStackTrace();
		}
	}
	
	public void excluir (ActionEvent evento){
		try {
			this.contrato = (Contrato) evento.getComponent().getAttributes().get("contratoSelecionado");
			
			ContratoRN contratoRN = new ContratoRN();
			contratoRN.excluir(contrato);
			
			this.contratos = contratoRN.listagem();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar remover o Contrato");
			erro.printStackTrace();
		}
	}
	
	public void editar (ActionEvent evento){

		this.contrato = (Contrato) evento.getComponent().getAttributes().get("contratoSelecionado");

	}

}
