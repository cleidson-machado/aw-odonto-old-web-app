package br.com.odontoclinic.comparadores;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.odontoclinic.model.base.contratante.Contratante;
import br.com.odontoclinic.stuff.contratante.ContratanteRN;
import br.com.odontoclinic.util.HibernateUtil;

public class ComparadorTest {

	public static void main ( String []args ){
		
		// Preparação para uso e acesso aos dados dentro desta Main
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();

		//Inicio das transações de consulta para todos os testes dessa classe
		Transaction tx = session.beginTransaction();
		
		//###########################################################################
		
		ContratanteRN contratanteRN = new ContratanteRN();
		Contratante contratante = new Contratante();
		
		contratante.setCpf("608.371.101-06");
		
		//SE TRUE = ENCONTROU NO BANCO
		//SE FALSE = NÃO ENCOTROU NO BANCO...
		
		//O MÉTODO PARA ESSE FIM NÃO PODE SER UNIC RESULT..!
		//O MEU PROBLEMA AQUI É QUANDO O unicResult não encontra nada... dá erro null pointer
		
		boolean veioDoBanco = contratanteRN.cpfJaCadastrado(contratante.getCpf());
		
		System.out.println("Resultado: " + veioDoBanco);
		
		//System.out.println("bbb " + veioDoBanco.getCpf().equals(contratante.getCpf())); 
		
		//###########################################################################
		
		//rolling back to save the test data
		tx.rollback();
						
		//closing hibernate resources
		sessionFactory.close();
	}
	
}
