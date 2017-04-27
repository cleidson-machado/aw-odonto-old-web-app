package br.com.odontoclinic.controller.checkout.procedimento;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.odontoclinic.model.base.checkout.procedimento.CheckOutProcedimento;
import br.com.odontoclinic.model.base.contrato.Contrato;
import br.com.odontoclinic.model.base.item.procedimento.ItemProcedimento;
import br.com.odontoclinic.stuff.contrato.ContratoRN;
import br.com.odontoclinic.stuff.item.procedimento.ItemProcedimentoRN;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CheckOutProcedimentoBean implements Serializable {
	
	//ATENÇÃO.. SERÁ UTILIZADO NA TELA DEFAULT... FUNCIONARÁ COMO UM TELA DE CAIXA..!
	
	//USADO NO DATATABLE DOS ITENS A ESCOLHER "PESQUISA"
	private List<ItemProcedimento> itemProcedimentos;
	
	//USADO NO DATA TABLE DO CARRINHO DE COMPRAS.. OU O QUE CHAMEI DE CHECKOUT..
	private List<CheckOutProcedimento> checkOutProcedimentos;
	
	//USADO NO BOTÃO DE ADICIONAR...
	private ItemProcedimento itemProcedimento;
	
	//USADO NO MOMENTO DE TRABALHAR COM O VALOR TOTAL DAS COMPRAS DE TODOS OS ITENS
	//VAI SALVAR ESSE VALOR TOTAL NA TABELA DE CONTRATO NO CAMPO ESPECÍFICO PARA ISSO...
	private Contrato contrato;
	
	//USAR NO SELECT ONE MENU AO FECHAR A TRANSAÇÃO..
	private List<Contrato> contratos;
	
	private CheckOutProcedimento checkOutProcedimento;
	
	public CheckOutProcedimento getCheckOutProcedimento() {
		return checkOutProcedimento;
	}
	
	public void setCheckOutProcedimento(CheckOutProcedimento checkOutProcedimento) {
		this.checkOutProcedimento = checkOutProcedimento;
	}
	
	public List<Contrato> getContratos() {
		return contratos;
	}
	
	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}
	
	public Contrato getContrato() {
		return contrato;
	}
	
	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}
	
	public ItemProcedimento getItemProcedimento() {
		return itemProcedimento;
	}
	
	public void setItemProcedimento(ItemProcedimento itemProcedimento) {
		this.itemProcedimento = itemProcedimento;
	}
	
	public List<CheckOutProcedimento> getCheckOutProcedimentos() {
		return checkOutProcedimentos;
	}
	
	public void setCheckOutProcedimentos(List<CheckOutProcedimento> checkOutProcedimentos) {
		this.checkOutProcedimentos = checkOutProcedimentos;
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
			contrato = new Contrato();
			contrato.setValorTotal(new BigDecimal("0.00"));
			contrato.setHorario(new Date());
			//checkOutProcedimento = new CheckOutProcedimento();
			//checkOutProcedimento.setValorParcial(new BigDecimal("0.00"));
			//checkOutProcedimento.setDtaVenda(new Date());
			
			ItemProcedimentoRN itemprocedimentoRN = new ItemProcedimentoRN();
			itemProcedimentos = itemprocedimentoRN.listagem();
			
			//Iniciando o Carrinho de Compras... ou seja o DataTable dele...
			checkOutProcedimentos = new ArrayList<>();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar listar um Procedimento" + erro);
			erro.printStackTrace();
		}
	}
	
	
	public void adicionar (ActionEvent evento){
		ItemProcedimento itemProcedimento = (ItemProcedimento) evento.getComponent().getAttributes().get("procedimentoSelecionado");
		
		int achou = -1;
		
		for(int posicao = 0; posicao < checkOutProcedimentos.size(); posicao++){
			if (checkOutProcedimentos.get(posicao).getItemProcedimento().equals(itemProcedimento)) {
				achou = posicao;
			}
		}
		
		if (achou < 0) {
			CheckOutProcedimento checkOutProcedimento = new CheckOutProcedimento();
			checkOutProcedimento.setValorParcial(itemProcedimento.getValorAtual());
			checkOutProcedimento.setQuantidade(new Short("1"));
			
			//FK do procedimento já cadastrado...
			checkOutProcedimento.setItemProcedimento(itemProcedimento);
			
			//vincular o Item ao CONTRATO também.... via FK do Contrato.
			checkOutProcedimento.setContrato(contrato);
			
			checkOutProcedimentos.add(checkOutProcedimento);
		
		}else{
			CheckOutProcedimento checkOutProcedimento = checkOutProcedimentos.get(achou);
			
			//Mini Gambiarra pois estou adicionanando a um Short então houve a necessidadade dessa conversão...
			checkOutProcedimento.setQuantidade(new Short(checkOutProcedimento.getQuantidade() + 1 + ""));
			checkOutProcedimento.setValorParcial(itemProcedimento.getValorAtual().multiply(new BigDecimal(checkOutProcedimento.getQuantidade())));
		}
		
		calcular();
		
	}
	
	public void remover(ActionEvent evento){
		
		CheckOutProcedimento checkOutProcedimento = (CheckOutProcedimento) evento.getComponent().getAttributes().get("itemProcedimentoSelecionado");
		
		int achou = -1;
		
		for (int posicao = 0; posicao < checkOutProcedimentos.size(); posicao++) {
				if (checkOutProcedimentos.get(posicao).getItemProcedimento().equals(checkOutProcedimento.getItemProcedimento())) {
					achou = posicao;
				}
		}
		
		if (achou > -1) {
			checkOutProcedimentos.remove(achou);
		}
		
		calcular();
		
	}
	
	//ATUAZA O VALOR DE TODOS OS ITENS ADICIONADOS OU SUBTRAIDOS DA VENDA CONTRATUAL
	public void calcular(){
		contrato.setValorTotal(new BigDecimal("0.00"));
		//checkOutProcedimento.setValorParcial(new BigDecimal("0.00"));
		
		for (int posicao = 0; posicao < checkOutProcedimentos.size(); posicao++) {
			CheckOutProcedimento checkOutProcedimento = checkOutProcedimentos.get(posicao);
			contrato.setValorTotal(contrato.getValorTotal().add(checkOutProcedimento.getValorParcial()));
			//checkOutProcedimento.setValorParcial(contrato.getValorTotal().add(checkOutProcedimento.getValorParcial()));
		}
	}
	
	public void finalizar(){
		try {
			contrato.setHorario(new Date());
			//checkOutProcedimento.setDtaVenda(new Date());
			
			ContratoRN contratoRN = new ContratoRN();
			this.contratos = contratoRN.listagem();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("ERRO ao tentar FINALIZAR a VENDA!" + erro);
			erro.printStackTrace();
		}
	}
	
	//SALVA A VENDA NA TAB. CORRESPONDENTE
	public void salvar(){
		try {
			if (checkOutProcedimento.getValorParcial().signum() == 0) {
				Messages.addGlobalError("Informe ao menos um Item para a Venda!");
				return;
			}
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("ERRO ao tentar SALVAR a VENDA!" + erro);
			erro.printStackTrace();
		}
	}


	public void novo(){
		
	}


	public void excluir (ActionEvent evento){
		
	}


	public void editar (ActionEvent evento){
		
	}

}
