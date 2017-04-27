package br.com.odontoclinic.consultas.listagem;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.odontoclinic.model.base.contratante.Contratante;
import br.com.odontoclinic.stuff.contratante.ContratanteRN;
import br.com.odontoclinic.util.HibernateUtil;

public class ListagemContratantePorCamadaFuncional {
	
	public static void main (String[] args){
		
		// Preparação para uso e acesso aos dados dentro desta Main
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();

		// Inicio das transações de consulta para todos os testes dessa classe
		Transaction tx = session.beginTransaction();
		// #####################################################################################
		
		ContratanteRN contratanteRN = new ContratanteRN();
		
		List<Contratante> testeConsulta = contratanteRN.listarApenasContratantes();
		
		for (Contratante dosPacientesList : testeConsulta) {
			System.out.println(dosPacientesList.getNome()); 
		}
		
		
		// #####################################################################################
		// rolling back to save the test data
		tx.rollback();

		// closing hibernate resources
		sessionFactory.close();
		
	}

}
