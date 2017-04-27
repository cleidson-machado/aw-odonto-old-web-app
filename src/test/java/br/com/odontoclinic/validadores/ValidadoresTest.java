package br.com.odontoclinic.validadores;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.odontoclinic.model.base.contratante.Contratante;
import br.com.odontoclinic.stuff.contratante.ContratanteRN;
import br.com.odontoclinic.util.HibernateUtil;

public class ValidadoresTest {
	
	public static void main (String [] args){
		
		// Preparação para uso e acesso aos dados dentro desta Main
				SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
				Session session = sessionFactory.getCurrentSession();
		
		//Inicio das transações de consulta para todos os testes dessa classe
		Transaction tx = session.beginTransaction();
		
		ContratanteRN contratanteRN = new ContratanteRN();
		Contratante contratante = new Contratante();
		
		//contratante.setCpf("381.476.438-29");
		contratante.setCpf("608.371.101-06");

		int contagem =	contratanteRN.contagemCpf(contratante.getCpf());
		
		if (contagem == 0) {
			System.out.println("Esse Cpf Não existe no Banco!");
		
		}else {
			System.out.println("CPF Já Cadastrado...");
		}
		
		System.out.println("Quantidade de CPF's encontrados: " + contagem);
		
		//rolling back to save the test data
		tx.rollback();
				
				//closing hibernate resources
		sessionFactory.close();
	}

}
