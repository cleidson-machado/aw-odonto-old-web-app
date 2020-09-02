package br.com.odontoclinic.consultas.listagem;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.odontoclinic.model.base.gestudo.Painel;
import br.com.odontoclinic.stuff.gestudo.painel.PainelRN;
import br.com.odontoclinic.util.HibernateUtil;

public class listagemPainelOriginal {
	
	public static void main (String[] args) {
		
		// Preparação para uso e acesso aos dados dentro desta Main
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		// Inicio das transações de consulta para todos os testes dessa classe
		Transaction tx = session.beginTransaction();
	
		//CRIADO PARA TESTE DA SINTAXE NO HQL
		// #####################################################################################
		PainelRN painelRN = new PainelRN();
		
		//List<Painel> consulta = painelRN.listOriginalIn();
		List<Painel> consulta = painelRN.listagem();
		
		for (Painel doPainel : consulta) {
			System.out.println(doPainel.getStatusFlag());
		}
		
		// #####################################################################################
		// rolling back to save the test data
		tx.rollback();
		
		// closing hibernate resources
		sessionFactory.close();
		
	}

}
