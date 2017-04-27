package br.com.odontoclinic.stuff.contratada;

import java.util.List;

import br.com.odontoclinic.model.base.contratada.Contratada;

public interface ContratadaDAO {
	
	public void salvar (Contratada contratada);
	public void editar  (Contratada contratada);
	public void excluir  (Contratada contratada);

	public Contratada carregar(Long codigo);

	public List<Contratada> listarTodos();

}
