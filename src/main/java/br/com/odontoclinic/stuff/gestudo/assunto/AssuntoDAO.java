package br.com.odontoclinic.stuff.gestudo.assunto;

import java.util.List;

import br.com.odontoclinic.model.base.gestudo.Assunto;

public interface AssuntoDAO {
	
	public void salvar (Assunto assunto);	
	public void editar (Assunto assunto);
	public void excluir (Assunto assunto);
	
	public Assunto carregar (Long codigo);
	
	public List<Assunto> listarTodos();

}
