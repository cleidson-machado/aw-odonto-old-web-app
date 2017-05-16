package br.com.odontoclinic.util;

import br.com.odontoclinic.stuff.checkout.procedimento.CheckOutProcedimentoDAO;
import br.com.odontoclinic.stuff.checkout.procedimento.CheckOutProcedimentoDAOHibernate;
import br.com.odontoclinic.stuff.contratada.ContratadaDAO;
import br.com.odontoclinic.stuff.contratada.ContratadaDAOHibernate;
import br.com.odontoclinic.stuff.contratante.ContratanteDAO;
import br.com.odontoclinic.stuff.contratante.ContratanteDAOHibernate;
import br.com.odontoclinic.stuff.contrato.ContratoDAO;
import br.com.odontoclinic.stuff.contrato.ContratoDAOHibernate;
import br.com.odontoclinic.stuff.endereco.EnderecoDAO;
import br.com.odontoclinic.stuff.endereco.EnderecoDAOHibernate;
import br.com.odontoclinic.stuff.item.procedimento.ItemProcedimentoDAO;
import br.com.odontoclinic.stuff.item.procedimento.ItemProcedimentoDAOHibernate;
import br.com.odontoclinic.stuff.referencia.ReferenciaDAO;
import br.com.odontoclinic.stuff.referencia.ReferenciaDAOHibernate;
import br.com.odontoclinic.stuff.usuario.UsuarioDAO;
import br.com.odontoclinic.stuff.usuario.UsuarioDAOHibernate;

public class DAOFactory {

	public static ContratanteDAO criarContratanteDAO() {
		ContratanteDAOHibernate contratanteDAO = new ContratanteDAOHibernate();
		contratanteDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return contratanteDAO;
	}

	public static ReferenciaDAO criarReferenciaDAO() {
		ReferenciaDAOHibernate referenciaDAO = new ReferenciaDAOHibernate();
		referenciaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return referenciaDAO;
	}

	public static EnderecoDAO criarEnderecoDAO() {
		EnderecoDAOHibernate enderecoDAO = new EnderecoDAOHibernate();
		enderecoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return enderecoDAO;
	}

	public static ContratadaDAO criarContratadaDAO() {
		ContratadaDAOHibernate contratadaDAO = new ContratadaDAOHibernate();
		contratadaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return contratadaDAO;
	}

	public static ContratoDAO criarContratoDAO() {
		ContratoDAOHibernate contratoDAO = new ContratoDAOHibernate();
		contratoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return contratoDAO;
	}

	public static ItemProcedimentoDAO criarItemProcedimentoDAO() {
		ItemProcedimentoDAOHibernate itemProcedimentoDAO = new ItemProcedimentoDAOHibernate();
		itemProcedimentoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return itemProcedimentoDAO;
	}

	public static CheckOutProcedimentoDAO criarCheckOutProcedimentoDAO() {
		CheckOutProcedimentoDAOHibernate checkOutProcedimentoDAO = new CheckOutProcedimentoDAOHibernate();
		checkOutProcedimentoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return checkOutProcedimentoDAO;
	}

	public static UsuarioDAO criarUsuarioDAO() {
		UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
	}

}
