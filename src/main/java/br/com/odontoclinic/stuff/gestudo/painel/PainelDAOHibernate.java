package br.com.odontoclinic.stuff.gestudo.painel;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.odontoclinic.model.base.gestudo.Painel;

public class PainelDAOHibernate implements PainelDAO {

	private Session session;

	public void setSession(Session session){
		this.session = session;
	}
	
	@Override
	public void salvar(Painel painel) {
		this.session.saveOrUpdate(painel);
		
	}

	@Override
	public void editar(Painel painel) {
		this.session.update(painel);
		
	}

	@Override
	public void excluir(Painel painel) {
		this.session.delete(painel);
		
	}

	@Override
	public Painel carregar(Long codigo) {
		return (Painel) this.session.get(Painel.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Painel> listarTodos() {
		return this.session.createCriteria(Painel.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Painel> listOriginalIn() {
		//AS VARIAÇÕES ABAIXO TAMBÉM FUNCIONAM...
		//String hql = "SELECT p FROM Painel p WHERE p.Original = 1 and p.Usuario <> 0";
		//String hql = "SELECT p FROM Painel p WHERE p.Original = 1 and p.usuario <> null";
		String hql = "SELECT p FROM Painel p WHERE p.Original = 1 and p.usuario >= 1";
		Query consulta = this.session.createQuery(hql);
		return consulta.list();
	}
	
	//CRIADO PARA EXIBIR A QUANTIDADE TOTAL DE NOVOS ITENS NÃO ORIGINAIS (TICKETS) DE PAINEL
	@SuppressWarnings("unchecked")
	@Override
	public List<Painel> listAllNotOriginalIn(){
		String hql = "SELECT p FROM Painel p WHERE p.Original = 0 and p.TipoAtendimento = 'NOVO'";
		Query consulta = this.session.createQuery(hql);
		return consulta.list();
	}
	
	//CRIADO PARA EXIBIR O PRIMEIRO ITEN NÃO ORIGINAL (TICKET) DE PAINEL
	@SuppressWarnings("unchecked")
	@Override
	public List<Painel> listTheFirstOneNotOriginalIn(){
		String hql = "SELECT p FROM Painel p WHERE p.Original = 0 and p.TipoAtendimento = 'NOVO' ORDER BY p.codigo ASC";
		Query consulta = this.session.createQuery(hql);
		return consulta.setMaxResults(1).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Painel> listAllTicketsAssumidos(){
		String hql = "SELECT p FROM Painel p WHERE p.Original = 0 and p.TipoAtendimento = 'ASSUMIDO'";
		Query consulta = this.session.createQuery(hql);
		return consulta.list();
	}

}
