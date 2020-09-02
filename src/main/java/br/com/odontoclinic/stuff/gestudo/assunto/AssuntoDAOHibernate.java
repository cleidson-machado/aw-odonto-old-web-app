package br.com.odontoclinic.stuff.gestudo.assunto;

import java.util.List;

import org.hibernate.Session;

import br.com.odontoclinic.model.base.gestudo.Assunto;

public class AssuntoDAOHibernate implements AssuntoDAO {

	private Session session;

	public void setSession(Session session){
		this.session = session;
	}
	
	@Override
	public void salvar(Assunto assunto) {
		this.session.saveOrUpdate(assunto);
		
	}

	@Override
	public void editar(Assunto assunto) {
		this.session.update(assunto); 
		
	}

	@Override
	public void excluir(Assunto assunto) {
		this.session.delete(assunto);
		
	}

	@Override
	public Assunto carregar(Long codigo) {
		return (Assunto) this.session.get(Assunto.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Assunto> listarTodos() {
		return this.session.createCriteria(Assunto.class).list();
	}

}
