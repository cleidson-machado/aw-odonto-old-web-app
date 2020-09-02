package br.com.odontoclinic.stuff.prova.produto;

import java.util.List;

import br.com.odontoclinic.model.base.prova.Produto;
import br.com.odontoclinic.util.DAOFactory;

public class ProdutoRN {
	
	private ProdutoDAO produtoDAO;
	
	//CONSTRUTOR..
	public ProdutoRN(){
		this.produtoDAO = DAOFactory.criarProdutoDAO();
	}

	public ProdutoDAO getProdutoDAO() {
		return produtoDAO;
	}

	public void setProdutoDAO(ProdutoDAO produtoDAO) {
		this.produtoDAO = produtoDAO;
	}
	
	//MÉTODOS PADRÃO...
	public void salvar (){
		//TO IMPLEMENT...	
	}
	
	public void editar (){
		//TO IMPLEMENT...	
	}
	
	public void excluir (){
		//TO IMPLEMENT...	
	}
	
	public List<Produto> listagem(){		
		return this.produtoDAO.listarTodos();
	}
	
	public Produto carregar (Long codigo){
		return this.produtoDAO.carregar(codigo);
	}	

}
