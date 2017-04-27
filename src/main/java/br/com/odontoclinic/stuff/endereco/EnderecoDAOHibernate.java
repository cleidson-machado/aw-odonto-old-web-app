package br.com.odontoclinic.stuff.endereco;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.odontoclinic.model.base.endereco.Endereco;

public class EnderecoDAOHibernate implements EnderecoDAO {
	
	private Session session;

	public void setSession(Session session){
		this.session = session;
	}

	@Override
	public void salvar(Endereco endereco) {
		this.session.saveOrUpdate(endereco);
		
	}

	@Override
	public void editar(Endereco endereco) {
		this.session.update(endereco);
		
	}

	@Override
	public void excluir(Endereco endereco) {
		this.session.delete(endereco); 
		
	}

	@Override
	public Endereco carregar(Long codigo) {
		return (Endereco) this.session.get(Endereco.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Endereco> listarTodos() {
		return this.session.createCriteria(Endereco.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Endereco> buscarPeloCep(String numCep) {
		String hql = "SELECT e FROM Endereco e WHERE e.CepPostal LIKE :CepInfo";
		Query consulta = this.session.createQuery(hql).setParameter("CepInfo", "%" + numCep + "%" );
		List<Endereco> resultados = consulta.list();
		return resultados;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List <Endereco> listarPorContratante(long codigo){
		String hql = "SELECT e FROM Endereco e WHERE e.contratante LIKE :doCodigo";
		Query consulta = this.session.createQuery(hql).setLong("doCodigo", codigo);
		List<Endereco> resultados = consulta.list();
		return resultados;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List <Endereco> listarPorReferencia(long codigo){
		String hql = "SELECT e FROM Endereco e WHERE e.referencia LIKE :doCodigo";
		Query consulta = this.session.createQuery(hql).setLong("doCodigo", codigo);
		List<Endereco> resultados = consulta.list();
		return resultados;
	}

}
