package br.com.odontoclinic.stuff.item.procedimento;

import java.util.List;

import br.com.odontoclinic.model.base.item.procedimento.ItemProcedimento;
import br.com.odontoclinic.util.DAOFactory;

public class ItemProcedimentoRN {
	
	private ItemProcedimentoDAO itemProcedimentoDAO;
	
	public ItemProcedimentoRN(){
		this.itemProcedimentoDAO = DAOFactory.criarItemProcedimentoDAO();
	}
	
	public ItemProcedimentoDAO getItemProcedimentoDAO() {
		return itemProcedimentoDAO;
	}
	
	public void setItemProcedimentoDAO(ItemProcedimentoDAO itemProcedimentoDAO) {
		this.itemProcedimentoDAO = itemProcedimentoDAO;
	}
	
	//MÉTODOS PADRÃO...
	public void salvar (ItemProcedimento itemProcedimento){
		this.itemProcedimentoDAO.salvar(itemProcedimento);
	}
	
	public void editar (ItemProcedimento itemProcedimento){
		this.itemProcedimentoDAO.editar(itemProcedimento);
	}
	
	public void excluir (ItemProcedimento itemProcedimento){
		this.itemProcedimentoDAO.excluir(itemProcedimento);
	}
	
	public List<ItemProcedimento> listagem(){
		return this.itemProcedimentoDAO.listarTodos();
	}
	
	public ItemProcedimento carregar (Long codigo){
		return this.itemProcedimentoDAO.carregar(codigo);
	}

}
