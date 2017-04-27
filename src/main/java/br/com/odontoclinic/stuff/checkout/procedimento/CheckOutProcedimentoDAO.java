package br.com.odontoclinic.stuff.checkout.procedimento;

import java.util.List;

import br.com.odontoclinic.model.base.checkout.procedimento.CheckOutProcedimento;
import br.com.odontoclinic.model.base.contrato.Contrato;

public interface CheckOutProcedimentoDAO {
	
	public void salvar (CheckOutProcedimento checkOutProcedimento);
	public void editar (CheckOutProcedimento checkOutProcedimento);
	public void excluir (CheckOutProcedimento checkOutProcedimento);
	
	public CheckOutProcedimento carregar (Long codigo);
	
	public List<CheckOutProcedimento> listarTodos();
	
	//SALVA UMA LISTA E NÃO SOMENTE UMA TUPLA NO BANCO..????
	public void salvarLista(List<CheckOutProcedimento> checkOutProcedimento);
	
	//NOVO TESTE... SALVA UMA LISTA E NÃO SOMENTE UMA TUPLA NO BANCO..????
	public void salvarVenda(Contrato contrato, List<CheckOutProcedimento> checkOutProcedimentos);

}
