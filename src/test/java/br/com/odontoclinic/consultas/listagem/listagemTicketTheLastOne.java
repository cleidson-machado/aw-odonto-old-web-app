package br.com.odontoclinic.consultas.listagem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.odontoclinic.util.HibernateUtil;

public class listagemTicketTheLastOne {
	
	public static void main (String[] args) {
		
		// Preparação para uso e acesso aos dados dentro desta Main
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();

		// Inicio das transações de consulta para todos os testes dessa classe
		Transaction tx = session.beginTransaction();
		
		// CRIADO PARA TESTE DA SINTAXE NO HQL
		// #####################################################################################
		
		String doStatus = "NAO";
		
		//int qtdRetornada = 0;
		
		//TicketRN ticketRN = new TicketRN();
		
		//Long idEncontrado = (Long) ticketRN.buscaNaoAtendidozzz(doStatus);
		
		//Ticket ticket = ticketRN.buscaNaoAtendido(doStatus);
		
		//String kkk = ticket.getSobreNome();
		
		//int qtdEncontrada = ticketRN.contaTicketInformado(doStatus);
		
		//List<Ticket> consulta = ticketRN.listAllRightNow();
		
		//List<Ticket> consulta = ticketRN.listAllFinished();
		
		//List<Ticket> consulta = ticketRN.listTheFirstOneNotOk();
		
		//List<Ticket> consulta = ticketRN.listAllNotFinished();
		
		//for (Ticket doticket : consulta) {
			//System.out.println("ID: " + doticket.getCodigo() + " --> " + doticket.getTxtRecado() + " --> " + doticket.getStatusFinalizado() ); 
		//}
		
		//System.out.println(idEncontrado); 
		
		// #####################################################################################
		// rolling back to save the test data
		tx.rollback();

		// closing hibernate resources
		sessionFactory.close();

	}

}
