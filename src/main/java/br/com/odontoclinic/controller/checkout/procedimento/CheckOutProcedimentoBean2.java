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
import br.com.odontoclinic.model.base.contratante.Contratante;
import br.com.odontoclinic.model.base.contrato.Contrato;
import br.com.odontoclinic.model.base.item.procedimento.ItemProcedimento;
import br.com.odontoclinic.stuff.checkout.procedimento.CheckOutProcedimentoRN;
import br.com.odontoclinic.stuff.contratante.ContratanteRN;
import br.com.odontoclinic.stuff.contrato.ContratoRN;
import br.com.odontoclinic.stuff.item.procedimento.ItemProcedimentoRN;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CheckOutProcedimentoBean2 implements Serializable {
	
	private Contrato contrato; //<<equivale a venda!
	
	private List<ItemProcedimento> itemProcedimentos;
	private List<CheckOutProcedimento> checkOutProcedimentos;
	private List<Contratante> contratantes; 
	
	private List<Contrato> contratos;
	
	//Criado para exibir a lista de contratos a esquerda...
	//Usado no DataTable a esquerda...
	public List<Contrato> getContratos() {
		ContratoRN contratoRN = new ContratoRN();
		if (contratos == null) {
			contratos = contratoRN.listagem();
		}
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
	
	public List<ItemProcedimento> getItemProcedimentos() {
		return itemProcedimentos;
	}
	
	public void setItemProcedimentos(List<ItemProcedimento> itemProcedimentos) {
		this.itemProcedimentos = itemProcedimentos;
	}
	
	public List<CheckOutProcedimento> getCheckOutProcedimentos() {
		return checkOutProcedimentos;
	}
	
	public void setCheckOutProcedimentos(List<CheckOutProcedimento> checkOutProcedimentos) {
		this.checkOutProcedimentos = checkOutProcedimentos;
	}
	
	public List<Contratante> getContratantes() {
		return contratantes;
	}
	
	public void setContratantes(List<Contratante> contratantes) {
		this.contratantes = contratantes;
	}
	
	@PostConstruct
	public void novo(){
		try {
			contrato = new Contrato();
			contrato.setPrecoTotal(new BigDecimal("0.00"));
			//contrato.setHorario(new Date()); //já usado no finalizar
			
			ItemProcedimentoRN itemprocedimentoRN = new ItemProcedimentoRN();
			itemProcedimentos = itemprocedimentoRN.listagem();
			
			//criado para update da Listagem a esquerda..
			ContratoRN contratoRN = new ContratoRN();
			contratos = contratoRN.listagem();
			
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
			
			//Data de venda do Item..
			checkOutProcedimento.setDtaVenda(new Date());
			
			//Status da Operação.. Inicialmente toda venda fica com "FINALIZADA" 
			//depois "CAIXA" quando houver o pagamento final no caixa da empresa...
			checkOutProcedimento.setStatusOperacao("FINALIZADA");
			
			//Coleta o valor do campo de uma classe e agrega a outra
			checkOutProcedimento.setPrecoParcial(itemProcedimento.getPreco());
			
			//Coleta o valor do campo de uma classe e agrega a outra
			checkOutProcedimento.setNotacaoCdiDente(itemProcedimento.getNotacaoCdiDente());
			
			//FK do procedimento que jáfoi cadastrado...
			checkOutProcedimento.setItemProcedimento(itemProcedimento); 
			
			//Quantidade inicial igual a um...
			checkOutProcedimento.setQuantidade(new Short("1"));
			
			checkOutProcedimentos.add(checkOutProcedimento);
		
		}else{
			CheckOutProcedimento checkOutProcedimento = checkOutProcedimentos.get(achou);
			
			//Acerta as quantidades...
			checkOutProcedimento.setQuantidade(new Short(checkOutProcedimento.getQuantidade() + 1 + ""));
			
			//Calcula valores em relação as quantidades...
			checkOutProcedimento.setPrecoParcial(itemProcedimento.getPreco().multiply(new BigDecimal(checkOutProcedimento.getQuantidade())));
		}
		
		calcular();
		
	}
	
	public void subtrair ( ActionEvent evento ){
		ItemProcedimento itemProcedimento = (ItemProcedimento) evento.getComponent().getAttributes().get("procedimentoSelecionado");
		
		int achou = -1;
		
		for(int posicao = 0; posicao < checkOutProcedimentos.size(); posicao++){
			if (checkOutProcedimentos.get(posicao).getItemProcedimento().equals(itemProcedimento)) {
				achou = posicao;
			}
		}
		
		if (achou < 0) {
			CheckOutProcedimento checkOutProcedimento = new CheckOutProcedimento();
			
			//Data de venda do Item..
			checkOutProcedimento.setDtaVenda(new Date());
			
			//Status da Operação.. Inicialmente toda venda fica com "FINALIZADA" 
			//depois "CAIXA" quando houver o pagamento final no caixa da empresa...
			checkOutProcedimento.setStatusOperacao("FINALIZADA");
			
			//Coleta o valor do campo de uma classe e agrega a outra
			checkOutProcedimento.setPrecoParcial(itemProcedimento.getPreco());
			
			//Coleta o valor do campo de uma classe e agrega a outra
			checkOutProcedimento.setNotacaoCdiDente(itemProcedimento.getNotacaoCdiDente());
			
			//FK do procedimento que jáfoi cadastrado...
			checkOutProcedimento.setItemProcedimento(itemProcedimento); 
			
			//Quantidade inicial igual a um...
			checkOutProcedimento.setQuantidade(new Short("1"));
			
			checkOutProcedimentos.add(checkOutProcedimento);
		
		}else{
			CheckOutProcedimento checkOutProcedimento = checkOutProcedimentos.get(achou);
			
			//Acerta as quantidades...
			checkOutProcedimento.setQuantidade(new Short(checkOutProcedimento.getQuantidade() - 1 + ""));
			
			//Calcula valores em relação as quantidades...
			checkOutProcedimento.setPrecoParcial(itemProcedimento.getPreco().multiply(new BigDecimal(checkOutProcedimento.getQuantidade())));
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
	
	
	public void calcular(){
		contrato.setPrecoTotal(new BigDecimal("0.00"));
		
		for (int posicao = 0; posicao < checkOutProcedimentos.size(); posicao++) {
			CheckOutProcedimento checkOutProcedimento = checkOutProcedimentos.get(posicao);
			contrato.setPrecoTotal(contrato.getPrecoTotal().add(checkOutProcedimento.getPrecoParcial()));
		}
	}
	
	public void finalizar(){
		try {
			contrato.setHorario(new Date());
			
			ContratanteRN contratanteRN = new ContratanteRN();
			contratantes = contratanteRN.listarApenasContratantes();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("ERRO ao tentar FINALIZAR a VENDA!" + erro);
			erro.printStackTrace();
		}
	}
	
	//SALVA A VENDA NAs TABs. CORRESPONDENTEs
	public void salvar(){
		try {
			if (contrato.getPrecoTotal().signum() == 0) {
				Messages.addGlobalError("Informe ao menos um Item para a Venda!");
				return;
			}
			
			ContratoRN contratoRN = new ContratoRN();
			contratoRN.salvar(contrato);
			
			CheckOutProcedimentoRN checkOutProcedimentoRN = new CheckOutProcedimentoRN();
			checkOutProcedimentoRN.salvarVenda(contrato, checkOutProcedimentos);
			
			novo();

			Messages.addGlobalInfo("Venda Realizada com sucesso!");
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("ERRO ao tentar SALVAR a VENDA!" + erro);
			erro.printStackTrace();
		}
	}

}
