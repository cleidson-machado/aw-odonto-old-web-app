package br.com.odontoclinic.controller.contratada;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.odontoclinic.model.base.contratada.Contratada;
import br.com.odontoclinic.stuff.contratada.ContratadaRN;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ContratadaBean implements Serializable {
	
	private Contratada contratada;
	private List<Contratada> contratadas;
	
	public Contratada getContratada() {
		return contratada;
	}
	
	public void setContratada(Contratada contratada) {
		this.contratada = contratada;
	}
	
	public List<Contratada> getContratadas() {
		return contratadas;
	}
	
	public void setContratadas(List<Contratada> contratadas) {
		this.contratadas = contratadas;
	}
	
	@PostConstruct
	public void listar(){
		try {
			ContratadaRN contratadaRN = new ContratadaRN();
			this.contratadas = contratadaRN.listagem();
			
		}  catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar listar a Contratada");
			erro.printStackTrace();
		}
		
	}

	public void novo(){
		try {
			this.contratada = new Contratada();
			
			ContratadaRN contratadaRN = new ContratadaRN();
			this.contratadas = contratadaRN.listagem();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao gerar uma nova Contratada");
			erro.printStackTrace();
		}
		
	}
	
	public void salvar(){
		try {
			ContratadaRN contratadaRN = new ContratadaRN();
			contratadaRN.salvar(this.contratada);
			
			this.contratada = new Contratada();
			this.contratadas = contratadaRN.listagem();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar salvar a Contratada");
			erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento){
		try {
				this.contratada = (Contratada) evento.getComponent().getAttributes().get("contratadaSelecionada");
				
				ContratadaRN contratadaRN = new ContratadaRN();
				contratadaRN.excluir(this.contratada);
				
				this.contratadas = contratadaRN.listagem();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar remover a Contratada");
			erro.printStackTrace();
		}
		
	}
	
	public void editar(ActionEvent evento){
		
				this.contratada = (Contratada) evento.getComponent().getAttributes().get("contratadaSelecionada");
	}
}
