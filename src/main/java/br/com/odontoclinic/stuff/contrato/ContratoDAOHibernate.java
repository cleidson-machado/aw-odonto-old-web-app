package br.com.odontoclinic.stuff.contrato;

import java.util.List;

import org.hibernate.Session;

import br.com.odontoclinic.model.base.contrato.Contrato;

public class ContratoDAOHibernate implements ContratoDAO {
	
	private Session session;

	public void setSession(Session session){
		this.session = session;
	}

	@Override
	public void salvar(Contrato contrato) {
		this.session.saveOrUpdate(contrato); 
	}

	@Override
	public void editar(Contrato contrato) {
		//Com a Programação para evitar a alteração da data de cdastro
		Contrato dataCadastral = this.carregar(contrato.getCodigo());
		contrato.setDtaCriacao(dataCadastral.getDtaCriacao());
		
		this.session.evict(dataCadastral);
		
		this.session.update(contrato);
	}

	@Override
	public void excluir(Contrato contrato) {
		this.session.delete(contrato);
	}

	@Override
	public Contrato carregar(Long codigo) {
		return (Contrato) this.session.get(Contrato.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contrato> listarTodos() {
		return this.session.createCriteria(Contrato.class).list();
	}

	
}
