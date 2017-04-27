package br.com.odontoclinic.stuff.contratada;

import java.util.List;

import org.hibernate.Session;

import br.com.odontoclinic.model.base.contratada.Contratada;

public class ContratadaDAOHibernate implements ContratadaDAO {
	
	private Session session;

	public void setSession(Session session){
		this.session = session;
	}

	@Override
	public void salvar(Contratada contratada) {
		this.session.saveOrUpdate(contratada);
	}

	@Override
	public void editar(Contratada contratada) {
		this.session.update(contratada);
	}

	@Override
	public void excluir(Contratada contratada) {
		this.session.delete(contratada); 
	}

	@Override
	public Contratada carregar(Long codigo) {
		return (Contratada) this.session.get(Contratada.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contratada> listarTodos() {
		return this.session.createCriteria(Contratada.class).list();
	}

}
