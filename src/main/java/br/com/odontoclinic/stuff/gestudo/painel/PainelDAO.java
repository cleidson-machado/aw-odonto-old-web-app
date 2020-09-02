package br.com.odontoclinic.stuff.gestudo.painel;

import java.util.List;

import br.com.odontoclinic.model.base.gestudo.Painel;

public interface PainelDAO {
	
	public void salvar (Painel painel);
	public void editar (Painel painel);
	public void excluir (Painel painel);
	
	public Painel carregar (Long codigo);
	
	public List<Painel> listarTodos();
	
	public List<Painel> listOriginalIn();
	
	//USADO NON FG (FILA GERAL) DO PAINEL
	public List<Painel> listAllNotOriginalIn();
	
	//USADO NO LISTDIALOG DO PAINEL
	public List<Painel> listTheFirstOneNotOriginalIn();
	
	//USADO PARA VISUALIZAR TICKTS ASSUMIDOS NO PAINEL
	public List<Painel> listAllTicketsAssumidos();

}
