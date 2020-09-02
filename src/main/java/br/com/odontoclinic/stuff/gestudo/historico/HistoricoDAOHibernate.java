package br.com.odontoclinic.stuff.gestudo.historico;

import java.util.List;

import org.hibernate.Session;

import br.com.odontoclinic.model.base.gestudo.Historico;

public class HistoricoDAOHibernate implements HistoricoDAO {

	private Session session;

	public void setSession(Session session){
		this.session = session;
	}
	
	@Override
	public void salvar(Historico historico) {
		this.session.saveOrUpdate(historico);
		
	}

	@Override
	public void editar(Historico historico) {
		this.session.update(historico);;
		
	}

	@Override
	public void excluir(Historico historico) {
		this.session.delete(historico); 
		
	}

	@Override
	public Historico carregar(Long codigo) {
		return (Historico) this.session.get(Historico.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Historico> listarTodos() {
		return this.session.createCriteria(Historico.class).list();
	}

}
