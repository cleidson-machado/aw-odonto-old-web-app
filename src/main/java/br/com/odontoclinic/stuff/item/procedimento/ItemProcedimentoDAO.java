package br.com.odontoclinic.stuff.item.procedimento;

import java.util.List;

import br.com.odontoclinic.model.base.item.procedimento.ItemProcedimento;

public interface ItemProcedimentoDAO {
	
	public void salvar (ItemProcedimento itemProcedimento);
	public void editar (ItemProcedimento itemProcedimento);
	public void excluir (ItemProcedimento itemProcedimento);
	
	public ItemProcedimento carregar (Long codigo);
	
	public List<ItemProcedimento> listarTodos();

}
