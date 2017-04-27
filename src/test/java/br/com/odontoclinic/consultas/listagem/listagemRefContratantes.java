package br.com.odontoclinic.consultas.listagem;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.odontoclinic.model.base.referencia.Referencia;
import br.com.odontoclinic.stuff.referencia.ReferenciaRN;
import br.com.odontoclinic.util.HibernateUtil;

public class listagemRefContratantes {

	public static void main(String[] args) {

		// Preparação para uso e acesso aos dados dentro desta Main
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();

		// Inicio das transações de consulta para todos os testes dessa classe
		Transaction tx = session.beginTransaction();
		
		//TESTE PARA O MÉTODO referenciaRN.listaRefPorContratante PASSANDO String codigo como parâmetro...
		//#####################################################################################

		//Referencia referencia = new Referencia();
//		Contratante contratante = new Contratante();
//		contratante.setCodigo(42L);
		
		ReferenciaRN referenciaRN = new ReferenciaRN();
		
		String codigo = "42";
		
		List<Referencia> testeConsulta = referenciaRN.listaRefPorContratante(codigo);
		
		//ESTUDAR MELHOR A DIFERENÇA ENTRE O FOR AVANÇADO E O COMUM.. OBS: ESSE É O AVANÇADO
		for (Referencia daReferenciaList : testeConsulta) {
			System.out.println(daReferenciaList.getNome());
		}
		
		//#####################################################################################

		// rolling back to save the test data
		tx.rollback();

		// closing hibernate resources
		sessionFactory.close();

	}
}
