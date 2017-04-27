package br.com.odontoclinic.controller.item.procedimento;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.odontoclinic.model.base.item.procedimento.ItemProcedimento;
import br.com.odontoclinic.stuff.item.procedimento.ItemProcedimentoRN;
import br.com.odontoclinic.stuff.item.procedimento.TipoItemProcedimento;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProcedimentoBean implements Serializable {
	
	//SERÁ UTILIZADO NA TELA DE CADASTRO DE PROCEDIMENTOS

	private ItemProcedimento itemProcedimento;
	private List<ItemProcedimento> itemProcedimentos;
	
	private TipoItemProcedimento tipoItemProcedimentoEnum;
	
	public TipoItemProcedimento[] getLabel(){
		return TipoItemProcedimento.values();
	}
	
	public TipoItemProcedimento getTipoItemProcedimentoEnum() {
		return tipoItemProcedimentoEnum;
	}

	public void setTipoItemProcedimentoEnum(TipoItemProcedimento tipoItemProcedimentoEnum) {
		this.tipoItemProcedimentoEnum = tipoItemProcedimentoEnum;
	}

	public ItemProcedimento getItemProcedimento() {
		return itemProcedimento;
	}
	
	public void setItemProcedimento(ItemProcedimento itemProcedimento) {
		this.itemProcedimento = itemProcedimento;
	}
	
	public List<ItemProcedimento> getItemProcedimentos() {
		return itemProcedimentos;
	}
	
	public void setItemProcedimentos(List<ItemProcedimento> itemProcedimentos) {
		this.itemProcedimentos = itemProcedimentos;
	}

	@PostConstruct
	public void listar(){
		try {
			
			ItemProcedimentoRN itemProcedimentoRN = new ItemProcedimentoRN();
			itemProcedimentos = itemProcedimentoRN.listagem();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar listar um Procedimento" + erro);
			erro.printStackTrace();
		}
	}
	
	public void novo(){
		try {
			this.itemProcedimento = new ItemProcedimento();
			
			ItemProcedimentoRN itemProcedimentoRN = new ItemProcedimentoRN();
			itemProcedimentos = itemProcedimentoRN.listagem();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao gerar um novo Procedimento" + erro);
			erro.printStackTrace();
		}
	}
	
	public void salvar(){
		try {
			ItemProcedimentoRN itemProcedimentoRN = new ItemProcedimentoRN();
			
			itemProcedimentoRN.salvar(this.itemProcedimento);
			
			itemProcedimento = new ItemProcedimento();
			itemProcedimentos = itemProcedimentoRN.listagem();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar salvar o Procedimento" + erro);
			erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento){
		try {
			this.itemProcedimento = (ItemProcedimento) evento.getComponent().getAttributes().get("procedimentoSelecionado");
			
			ItemProcedimentoRN itemProcedimentoRN = new ItemProcedimentoRN();
			itemProcedimentoRN.excluir(itemProcedimento);
			
			itemProcedimentos = itemProcedimentoRN.listagem();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar remover o Procedimento");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento){

		this.itemProcedimento = (ItemProcedimento) evento.getComponent().getAttributes().get("procedimentoSelecionado");

	}

}
