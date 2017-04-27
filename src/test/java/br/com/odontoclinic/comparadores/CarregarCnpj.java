package br.com.odontoclinic.comparadores;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.odontoclinic.model.base.contratante.Contratante;
import br.com.odontoclinic.stuff.contratante.ContratanteRN;
import br.com.odontoclinic.util.HibernateUtil;

public class CarregarCnpj {
	
	//CLASSE CRIADA PARA TESTE EM RELAÇÃO A COMPARAÇÕES COM DADOS NULOS OU VAZIOS NAS TUPLAS SELECIONADAS...
	
	public static void main ( String []args ){
		
		// Preparação para uso e acesso aos dados dentro desta Main
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();

		// Inicio das transações de consulta para todos os testes dessa classe
		Transaction tx = session.beginTransaction();

		// ###########################################################################

		Contratante contratante = new Contratante();
		
		contratante.setCodigo(42L);
		
		ContratanteRN contratanteRN = new ContratanteRN();
		
		Contratante selecionado = contratanteRN.carregar(contratante.getCodigo());
		
		String uuu = selecionado.getCnpj();
		
		System.out.println( uuu + "  -kkkk" );
		
		if (selecionado.getCnpj() != null) {
			System.out.println("Passou aqui e está nulo! inverso");
		}else{
			System.out.println("Não Nulo..!");
		}
		
		
		// ###########################################################################

		// rolling back to save the test data
		tx.rollback();

		// closing hibernate resources
		sessionFactory.close();
		
	}

}
