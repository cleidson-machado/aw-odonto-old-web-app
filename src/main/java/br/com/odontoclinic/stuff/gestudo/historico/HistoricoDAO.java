package br.com.odontoclinic.stuff.gestudo.historico;

import java.util.List;

import br.com.odontoclinic.model.base.gestudo.Historico;

public interface HistoricoDAO {
	
	public void salvar (Historico historico);	
	public void editar (Historico historico);
	public void excluir (Historico historico);
	
	public Historico carregar (Long codigo);
	
	public List<Historico> listarTodos();

}
