package br.com.odontoclinic.controller.referencia;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.odontoclinic.model.base.contratante.Contratante;
import br.com.odontoclinic.model.base.referencia.Referencia;
import br.com.odontoclinic.stuff.contratante.ContratanteRN;
import br.com.odontoclinic.stuff.referencia.ReferenciaRN;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped 
public class ReferenciaBean implements Serializable {
	
	private Referencia referencia;
	
	private List<Referencia> referencias;
	private List<Contratante> contratantes;
	
	public Referencia getReferencia() {
		if (this.referencia == null) {
			this.referencia = new Referencia();
		}
		return referencia;
	}
	public void setReferencia(Referencia referencia) {
		this.referencia = referencia;
	}
	
	public List<Referencia> getReferencias() {
		return referencias;
	}
	public void setReferencias(List<Referencia> referencias) {
		this.referencias = referencias;
	}
	
	//USADO NO SELECT ONE MENU
	public List<Contratante> getContratantes() {
		return contratantes;
	}
	
	public void setContratantes(List<Contratante> contratantes) {
		this.contratantes = contratantes;
	}
	
	@PostConstruct
	public void Listar(){
		try {
			
			ReferenciaRN referenciaRN = new ReferenciaRN();
			referencias = referenciaRN.listagem();
			
			ContratanteRN contratanteRN = new ContratanteRN();
			contratantes = contratanteRN.listarApenasContratantes();
			
		}  catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar listar Refências e Contratantes");
			erro.printStackTrace();
		}
	}
	
	public void novo(){
		try {
			referencia = new Referencia();
			
			ReferenciaRN referenciaRN = new ReferenciaRN();
			referencias = referenciaRN.listagem();
			
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao gerar uma nova Referência");
			erro.printStackTrace();
		}
	}
	

	public void salvar(){
		try {
			ReferenciaRN referenciaRN = new ReferenciaRN();
			referenciaRN.salvar(referencia);
			
			referencia = new Referencia();
			referencias = referenciaRN.listagem();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar salvar a Referência");
			erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento){
		try {
			referencia = (Referencia) evento.getComponent().getAttributes().get("referenciaSelecionada");
			
			ReferenciaRN referenciaRN = new ReferenciaRN();
			referenciaRN.excluir(referencia);

			referencias = referenciaRN.listagem();

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar remover o Referência");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento){
			
		referencia = (Referencia) evento.getComponent().getAttributes().get("referenciaSelecionada");
	
	}
	
}
