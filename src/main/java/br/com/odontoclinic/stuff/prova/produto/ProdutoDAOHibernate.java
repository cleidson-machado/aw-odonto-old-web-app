package br.com.odontoclinic.stuff.prova.produto;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import br.com.odontoclinic.model.base.prova.Produto;

public class ProdutoDAOHibernate implements ProdutoDAO {

	private Session session;

	public void setSession(Session session){
		this.session = session;
	}
	
	@Override
	public void salvar(Produto produto) {
		
		produto.setDescricao("Mais um produto tetse..");
		produto.setDataCadProduto(new Date());
		
		this.session.saveOrUpdate(produto);
	}

	@Override
	public void editar(Produto produto) {
		this.session.update(produto);
	}

	@Override
	public void excluir(Produto produto) {
		this.session.delete(produto);
	}

	@Override
	public Produto carregar(Long codigo) {		
		return (Produto) this.session.get(Produto.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> listarTodos() {
		return this.session.createCriteria(Produto.class).list();
	}

}
