package br.com.odontoclinic.stuff.prova.rua;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.odontoclinic.model.base.prova.Rua;

public class RuaDAOHibernate implements RuaDAO {

	private Session session;

	public void setSession(Session session){
		this.session = session;
	}
	
	@Override
	public void salvar(Rua rua) {
		this.session.saveOrUpdate(rua);
		
	}

	@Override
	public void ediar(Rua rua) {
		this.session.update(rua);
		
	}

	@Override
	public void excluir(Rua rua) {
		this.session.delete(rua);
		
	}

	@Override
	public Rua carregar(Long codigo) {
		return (Rua) this.session.get(Rua.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rua> listarTodos() {
		return this.session.createCriteria(Rua.class).list();
	}
	
	//TESTE LISTAR TODOS VIA CONSULTA HQL...
	@SuppressWarnings("unchecked")
	@Override
	public List<Rua> listarTesteHql(){
		//String hql = "SELECT r FROM Rua r";
		String hql = "SELECT r, c FROM Rua r INNER JOIN Contribuinte c "
				   + "ON r.codigo = c.rua_codigo WHERE r.codigo = 2";
		Query consulta = this.session.createQuery(hql);
		return consulta.list();
	}
	
	//MÉTODOS PERSONALIZADOS...
	//PRA CONTAR QUANTOS CONTRIBUINTES EXISTEM PRA CADA RUA...
	@Override
	public int contaContribuinteXRua(Long codigo) {
		String hql = "SELECT r FROM Rua r WHERE r.codigo LIKE :idContribuinte";
		Query consulta = this.session.createQuery(hql);
		consulta.setLong("idContribuinte", codigo);
		return consulta.list().size();
	}
	
	//PRA CONTAR QUANTOS CONTRIBUINTES EXISTEM PRA CADA RUA... test 2
	@SuppressWarnings("unchecked")
	@Override
	public List<Rua> listarQtdRuaPorContribuinte(String codigo){
		String hql = "SELECT r, c FROM Rua r INNER JOIN Contribuinte c "
				   + "ON r.codigo = c.rua_codigo WHERE r.codigo = :idRuaInfo";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("idRuaInfo", codigo);
		return consulta.list();
	}

}
