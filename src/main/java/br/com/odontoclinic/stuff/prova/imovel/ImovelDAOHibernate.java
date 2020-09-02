package br.com.odontoclinic.stuff.prova.imovel;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.odontoclinic.model.base.prova.Imovel;

public class ImovelDAOHibernate implements ImovelDAO {

	private Session session;

	public void setSession(Session session){
		this.session = session;
	}
	
	@Override
	public void salvar(Imovel imovel) {
		this.session.saveOrUpdate(imovel);
	}

	@Override
	public void editar(Imovel imovel) {
		// objetivo evitar receber dados que venham
		// do campo da inscrição
		Imovel inscricaoInfo = this.carregar(imovel.getCodigo());
		imovel.setInscricao(inscricaoInfo.getInscricao());

		this.session.evict(inscricaoInfo);

		this.session.update(imovel);

	}

	@Override
	public void excluir(Imovel imovel) {
		this.session.delete(imovel);
		
	}

	@Override
	public Imovel carregar(Long codigo) {
		return (Imovel) this.session.get(Imovel.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Imovel> listarTodos() {
		return this.session.createCriteria(Imovel.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Imovel> listadoPorContribuinte(long codigo) {
		String hql = "SELECT k FROM Imovel k WHERE k.contribuinte LIKE :doCodigo";
		Query consulta = this.session.createQuery(hql).setLong("doCodigo", codigo);
		List<Imovel> resultados = consulta.list();
		return resultados;
	}
	
	//BUSCAS1...
	@SuppressWarnings("unchecked")
	@Override
	public List<Imovel> listagemZeroContribuinte() {
		String hql = "SELECT k FROM Imovel k WHERE k.contribuinte = NULL";
		Query consulta = this.session.createQuery(hql);
		return consulta.list();
	}
	
	//BUSCAS2...
	@SuppressWarnings("unchecked")
	@Override
	public List<Imovel> listagemAlgumContribuinte() {
		String hql = "SELECT k FROM Imovel k WHERE k.contribuinte <> NULL";
		Query consulta = this.session.createQuery(hql);
		return consulta.list();
	}

	//BUSCAS4...
	@SuppressWarnings("unchecked")
	@Override
	public List<Imovel> listagemContratantePorNome(String doNome) {
		String hql = "SELECT k FROM Imovel k WHERE k.contribuinte.Nome LIKE :doNome OR k.contribuinte.SobreNome LIKE :doNome";
		Query consulta = this.session.createQuery(hql).setParameter("doNome", "%" + doNome + "%" );
		//List<Imovel> resultados = consulta.list();
		return consulta.list();
	}

}
