package br.com.odontoclinic.stuff.checkout.procedimento;

import java.util.List;

import br.com.odontoclinic.model.base.checkout.procedimento.CheckOutProcedimento;
import br.com.odontoclinic.model.base.contrato.Contrato;
import br.com.odontoclinic.stuff.contrato.ContratoDAO;
import br.com.odontoclinic.util.DAOFactory;

public class CheckOutProcedimentoRN {
	
	private CheckOutProcedimentoDAO checkOutProcedimentoDAO;
	private ContratoDAO contratoDAO;
	
	public CheckOutProcedimentoRN(){
		this.checkOutProcedimentoDAO = DAOFactory.criarCheckOutProcedimentoDAO();
		this.contratoDAO = DAOFactory.criarContratoDAO();
	}
	
	public CheckOutProcedimentoDAO getCheckOutProcedimentoDAO() {
		return checkOutProcedimentoDAO;
	}
	
	public void setCheckOutProcedimentoDAO(CheckOutProcedimentoDAO checkOutProcedimentoDAO) {
		this.checkOutProcedimentoDAO = checkOutProcedimentoDAO;
	}
	
	public ContratoDAO getContratoDAO() {
		return contratoDAO;
	}
	
	public void setContratoDAO(ContratoDAO contratoDAO) {
		this.contratoDAO = contratoDAO;
	}

	//MÉTODOS PADRÃO...
	public void salvar (CheckOutProcedimento checkOutProcedimento){
		this.checkOutProcedimentoDAO.salvar(checkOutProcedimento);
	}
	
	public void editar (CheckOutProcedimento checkOutProcedimento){
		this.checkOutProcedimentoDAO.editar(checkOutProcedimento);
	}
	
	public void excluir (CheckOutProcedimento checkOutProcedimento){
		this.checkOutProcedimentoDAO.excluir(checkOutProcedimento);
	}
	
	public List <CheckOutProcedimento> listagem(){
		return this.checkOutProcedimentoDAO.listarTodos();
	}
	
	public CheckOutProcedimento carregar (Long codigo){
		return this.checkOutProcedimentoDAO.carregar(codigo);
	}

	//COMO SALVAR UMA LISTA E NÃO SOMENTE UMA TUPLA NO BANCO..????
	public void salvarLista(List<CheckOutProcedimento> checkOutProcedimento) {
		this.checkOutProcedimentoDAO.salvarLista(checkOutProcedimento);
		
	}

	//TESTE 2 SALVAR UMA LISTA E NÃO SOMENTE UMA TUPLA NO BANCO..
	public void salvarVenda(Contrato contrato, List<CheckOutProcedimento> checkOutProcedimentos){
		this.checkOutProcedimentoDAO.salvarVenda(contrato, checkOutProcedimentos);
		
	}
	
}
