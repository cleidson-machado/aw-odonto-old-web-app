package br.com.odontoclinic.stuff.gestudo.cliente;

import java.util.List;

import org.hibernate.Session;

import br.com.odontoclinic.model.base.gestudo.Cliente;

public class ClienteDAOHibernate implements ClienteDAO {
	
	private Session session;

	public void setSession(Session session){
		this.session = session;
	}

	@Override
	public void salvar(Cliente cliente) {
		this.session.saveOrUpdate(cliente); 
		
	}

	@Override
	public void editar(Cliente cliente) {
		this.session.update(cliente);
		
	}

	@Override
	public void excluir(Cliente cliente) {
		this.session.delete(cliente);
		
	}

	@Override
	public Cliente carregar(Long codigo) {
		return (Cliente) this.session.get(Cliente.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> listarTodos() {
		return this.session.createCriteria(Cliente.class).list();
	}

}
