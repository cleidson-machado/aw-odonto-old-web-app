package br.com.odontoclinic.stuff.gestudo.cliente;

import java.util.List;

import br.com.odontoclinic.model.base.gestudo.Cliente;

public interface ClienteDAO {
	
	public void salvar (Cliente cliente);
	public void editar (Cliente cliente);
	public void excluir (Cliente cliente);
	
	public Cliente carregar (Long codigo);
	
	public List<Cliente> listarTodos();

}
