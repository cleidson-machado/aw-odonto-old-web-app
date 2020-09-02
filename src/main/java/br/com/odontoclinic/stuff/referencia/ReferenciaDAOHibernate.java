package br.com.odontoclinic.stuff.referencia;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.odontoclinic.model.base.referencia.Referencia;

public class ReferenciaDAOHibernate implements ReferenciaDAO {

	private Session session;

	public void setSession(Session session){
		this.session = session;
	}
	
	@Override
	public void salvar(Referencia referencia) {
		if (referencia.getCodigo() != null) {
			this.session.update(referencia);
		} else {
			this.session.save(referencia);
		}
	}
	
	//Não está sendo usado com os Dialogs Padrão do curso do Delfino
	@Override
	public void editar(Referencia referencia) {
		this.session.saveOrUpdate(referencia);		
	}

	@Override
	public void excluir(Referencia referencia) {
		this.session.delete(referencia);
		
	}

	@Override
	public Referencia carregar(Long codigo) {
		return (Referencia) this.session.get(Referencia.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Referencia> listarTodos() {
		return this.session.createCriteria(Referencia.class).list();
	}
	
	//ESTUDO... NÃO USADO NO PROJETO...
	//MÉTODO PARA LISTAR TODAS AS REFERÊNCIAS DE UMA DETERMINADA CONTRATANTE...
	//USANDO UMA String NOS PARÂMETROS... MAS NO JAVA LIDO COM Long pois é uma FK..
	@SuppressWarnings("unchecked")
	@Override
	public List<Referencia> listarRefPorContratante(String codigo){
		String hql = "SELECT r FROM Referencia r WHERE r.contratante LIKE :doCodigo";
		Query consulta = this.session.createQuery(hql).setString("doCodigo", codigo);
		List<Referencia> resultados = consulta.list();
		return resultados;
	}
	
	//MÉTODO PARA LISTAR TODAS AS REFERÊNCIAS DE UMA DETERMINADA CONTRATANTE... IGUAL O ANTERIOR...
	//MAS USANDO O long NOS PARÊMETROS
	@SuppressWarnings("unchecked")
	@Override
	public List<Referencia> listarPorContratante(long codigo){
		String hql = "SELECT r FROM Referencia r WHERE r.contratante LIKE :doCodigo";
		Query consulta = this.session.createQuery(hql).setLong("doCodigo", codigo);
		List<Referencia> resultados = consulta.list();
		return resultados;
	}
	
	
	
	
	
	
	

}
