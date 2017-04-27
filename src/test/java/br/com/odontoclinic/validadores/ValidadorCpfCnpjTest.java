package br.com.odontoclinic.validadores;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.odontoclinic.model.base.contratante.Contratante;
import br.com.odontoclinic.regras.validacao.ValidateCpfCnpj;
import br.com.odontoclinic.util.HibernateUtil;

public class ValidadorCpfCnpjTest {
	
	public static void main (String [] args){
		// Preparação para uso e acesso aos dados dentro desta Main
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();

		//Inicio das transações de consulta para todos os testes dessa classe
		Transaction tx = session.beginTransaction();

		Contratante contratante = new Contratante();
		ValidateCpfCnpj validador = new ValidateCpfCnpj();

		contratante.setCpf("608.371.101-06");
		
		@SuppressWarnings({ "static-access", "unused" })
		boolean correto = validador.validarCPF(contratante.getCpf());
		
		//rolling back to save the test data
		tx.rollback();
						
		//closing hibernate resources
		sessionFactory.close();
	}

	


}
