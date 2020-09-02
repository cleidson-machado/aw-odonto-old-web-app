package br.com.odontoclinic.stuff.prova.produto;

import java.util.List;

import br.com.odontoclinic.model.base.prova.Produto;

public interface ProdutoDAO {
	
	public void salvar (Produto produto);
	
	public void editar (Produto produto);
	
	public void excluir (Produto produto);
	
	public Produto carregar (Long codigo);
	
	public List<Produto> listarTodos();

}
