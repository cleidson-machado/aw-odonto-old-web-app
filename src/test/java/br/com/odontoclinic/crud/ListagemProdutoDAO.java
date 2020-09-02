package br.com.odontoclinic.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.odontoclinic.model.base.prova.Produto;
import br.com.odontoclinic.stuff.prova.produto.ProdutoRN;
import br.com.odontoclinic.util.HibernateUtil;

public class ListagemProdutoDAO {
	
	public static void main (String[] args) {
	
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		// Inicio das transações de consulta para todos os testes dessa classe
		Transaction tx = session.beginTransaction();
		// #####################################################################################
				
				ProdutoRN produtoRN = new ProdutoRN();
				
				List<Produto> consulta = produtoRN.listagem();
				
				for (Produto doProduto : consulta){
					System.out.println(doProduto.getCategoria());
				}
				
		
		// #####################################################################################
		// rolling back to save the test data
		tx.rollback();
				
		// closing hibernate resources
		sessionFactory.close();
		
	}

}
