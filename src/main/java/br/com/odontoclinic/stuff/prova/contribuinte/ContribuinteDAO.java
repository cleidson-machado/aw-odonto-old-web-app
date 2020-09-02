package br.com.odontoclinic.stuff.prova.contribuinte;

import java.util.List;

import br.com.odontoclinic.model.base.prova.Contribuinte;

public interface ContribuinteDAO {
	
	public void salvar(Contribuinte contribuinte);
	public void editar(Contribuinte contribuinte);
	public void excluir(Contribuinte contribuinte);
	
	public Contribuinte carrregar (Long codigo);
	
	public List<Contribuinte> listarTodos();
	
	public List<Contribuinte> listadoPorRua(long codigo);

}
