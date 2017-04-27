package br.com.odontoclinic.consultas.listagem;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.odontoclinic.model.base.endereco.Endereco;
import br.com.odontoclinic.stuff.endereco.EnderecoRN;
import br.com.odontoclinic.util.HibernateUtil;

public class listagemReferenciaEndereco {
	
	
	public static void main (String[] args){
		
		// Preparação para uso e acesso aos dados dentro desta Main
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();

		// Inicio das transações de consulta para todos os testes dessa classe
		Transaction tx = session.beginTransaction();

		// TESTE PARA O MÉTODO referenciaRN.listaRefContratante PASSANDO
		// Long codigo como parâmetro...
		// #####################################################################################
		EnderecoRN enderecoRN = new EnderecoRN();
		
		long codigo = 1L;
		
		List<Endereco> testeConsulta = enderecoRN.listarPorReferencia(codigo);
		
		for( Endereco doEnderecoList : testeConsulta ){
			System.out.println(doEnderecoList.getLogradouro() + " --> " + doEnderecoList.getReferencia().getNome());
		}
		
		
		// #####################################################################################
		// rolling back to save the test data
		tx.rollback();

		// closing hibernate resources
		sessionFactory.close();
		
	}
	

}
