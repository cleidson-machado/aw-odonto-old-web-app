package br.com.odontoclinic.stuff.gestudo.cliente;

import java.util.List;

import br.com.odontoclinic.model.base.gestudo.Cliente;
import br.com.odontoclinic.util.DAOFactory;

public class ClienteRN {
	
	private ClienteDAO clienteDAO;
	
	public ClienteRN() {
		this.clienteDAO = DAOFactory.criarClienteDAO();
	}

	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}
	
	//MÉTODOS PADRÃO...
	public void salvar (Cliente cliente) {
		this.clienteDAO.salvar(cliente);
	}
	
	public void editar (Cliente cliente) {
		this.clienteDAO.editar(cliente);
	}
	
	public void excluir (Cliente cliente) {
		this.clienteDAO.excluir(cliente);
	}
	
	public List<Cliente> listagem(){
		return this.clienteDAO.listarTodos();
	}
	
	public Cliente carregar (Long codigo) {
		return this.clienteDAO.carregar(codigo);
	}
	
	//MÉTODOS PERSONALIZADOS

}
