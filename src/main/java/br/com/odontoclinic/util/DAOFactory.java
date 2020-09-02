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
import br.com.odontoclinic.stuff.gestudo.assunto.AssuntoDAO;
import br.com.odontoclinic.stuff.gestudo.assunto.AssuntoDAOHibernate;
import br.com.odontoclinic.stuff.gestudo.cliente.ClienteDAO;
import br.com.odontoclinic.stuff.gestudo.cliente.ClienteDAOHibernate;
import br.com.odontoclinic.stuff.gestudo.historico.HistoricoDAO;
import br.com.odontoclinic.stuff.gestudo.historico.HistoricoDAOHibernate;
import br.com.odontoclinic.stuff.gestudo.painel.PainelDAO;
import br.com.odontoclinic.stuff.gestudo.painel.PainelDAOHibernate;
import br.com.odontoclinic.stuff.item.procedimento.ItemProcedimentoDAO;
import br.com.odontoclinic.stuff.item.procedimento.ItemProcedimentoDAOHibernate;
import br.com.odontoclinic.stuff.prova.contribuinte.ContribuinteDAO;
import br.com.odontoclinic.stuff.prova.contribuinte.ContribuinteDAOHibernate;
import br.com.odontoclinic.stuff.prova.imovel.ImovelDAO;
import br.com.odontoclinic.stuff.prova.imovel.ImovelDAOHibernate;
import br.com.odontoclinic.stuff.prova.produto.ProdutoDAO;
import br.com.odontoclinic.stuff.prova.produto.ProdutoDAOHibernate;
import br.com.odontoclinic.stuff.prova.rua.RuaDAO;
import br.com.odontoclinic.stuff.prova.rua.RuaDAOHibernate;
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

	public static ContribuinteDAO criarContribuinteDAO() {
		ContribuinteDAOHibernate contribuinteDAO = new ContribuinteDAOHibernate();
		contribuinteDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return contribuinteDAO;
	}

	public static ImovelDAO criarImovelDAO() {
		ImovelDAOHibernate imovelDAO = new ImovelDAOHibernate();
		imovelDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return imovelDAO;
	}

	public static RuaDAO criarRuaDAO() {
		RuaDAOHibernate ruaDAO = new RuaDAOHibernate();
		ruaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return ruaDAO;
	}

	public static PainelDAO criarPainelDAO() {
		PainelDAOHibernate painelDAO = new PainelDAOHibernate();
		painelDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return painelDAO;
	}

	public static AssuntoDAO criarAssuntoDAO() {
		AssuntoDAOHibernate assuntoDAO = new AssuntoDAOHibernate();
		assuntoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return assuntoDAO;
	}

	public static ClienteDAO criarClienteDAO() {
		ClienteDAOHibernate clienteDAO = new ClienteDAOHibernate();
		clienteDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return clienteDAO;
	}

	public static HistoricoDAO criarHistoricoDAO() {
		HistoricoDAOHibernate historicoDAO = new HistoricoDAOHibernate();
		historicoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return historicoDAO;
	}

	public static ProdutoDAO criarProdutoDAO() {
		ProdutoDAOHibernate produtoDAO = new ProdutoDAOHibernate();
		produtoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return produtoDAO;
	}

}
