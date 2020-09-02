package br.com.odontoclinic.stuff.prova.contribuinte;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.odontoclinic.model.base.prova.Contribuinte;

public class ContribuinteDAOHibernate implements ContribuinteDAO {

	private Session session;

	public void setSession(Session session){
		this.session = session;
	}
	
	@Override
	public void salvar(Contribuinte contribuinte) {
		this.session.saveOrUpdate(contribuinte);
		
	}

	//teste pra salvar o ID FK da Rua ao editar o Contribuinte... 
	@Override
	public void editar(Contribuinte contribuinte) {
		
		//Contribuinte xxxx = this.carrregar(contribuinte.getCodigo());
		//contribuinte.setRua(xxxx.getRua());
		
		this.session.update(contribuinte);
		
	}

	@Override
	public void excluir(Contribuinte contribuinte) {
		this.session.delete(contribuinte);
		
	}

	@Override
	public Contribuinte carrregar(Long codigo) {
		return (Contribuinte) this.session.get(Contribuinte.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contribuinte> listarTodos() {
		return this.session.createCriteria(Contribuinte.class).list();
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Contribuinte> listadoPorRua(long codigo) {
		String hql = "SELECT c FROM Contribuinte c WHERE c.rua LIKE :doCodigo";
		Query consulta = this.session.createQuery(hql).setLong("doCodigo", codigo);
		List<Contribuinte> resultados = consulta.list();
		return resultados;
	}
	
	
	
	

}
