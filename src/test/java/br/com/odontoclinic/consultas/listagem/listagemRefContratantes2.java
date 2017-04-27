package br.com.odontoclinic.consultas.listagem;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.odontoclinic.model.base.referencia.Referencia;
import br.com.odontoclinic.stuff.referencia.ReferenciaRN;
import br.com.odontoclinic.util.HibernateUtil;

public class listagemRefContratantes2 {
	
	public static void main (String[] args){
		
		// Preparação para uso e acesso aos dados dentro desta Main
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();

		// Inicio das transações de consulta para todos os testes dessa classe
		Transaction tx = session.beginTransaction();

		// TESTE PARA O MÉTODO referenciaRN.listaRefContratante PASSANDO
		// Long codigo como parâmetro...
		// #####################################################################################		
		ReferenciaRN referenciaRN = new ReferenciaRN();
		
		long codigo = 42L;
	
		List<Referencia> testeConsulta = referenciaRN.listaRefContratante(codigo);
		
		for(Referencia daReferenciaList : testeConsulta ){
			System.out.println(daReferenciaList.getNome()); 
		}
		
		// #####################################################################################
		// rolling back to save the test data
		tx.rollback();

		// closing hibernate resources
		sessionFactory.close();
		
	}

}
