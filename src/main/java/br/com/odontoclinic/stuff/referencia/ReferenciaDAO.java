package br.com.odontoclinic.stuff.referencia;

import java.util.List;

import br.com.odontoclinic.model.base.referencia.Referencia;

public interface ReferenciaDAO {

	public void salvar (Referencia referencia);
	public void editar (Referencia referencia);
	public void excluir (Referencia referencia);
	
	public Referencia carregar (Long codigo);
	
	public List<Referencia> listarTodos();
	
	//ESTUDO... NÃO USADO NO PROJETO...
	public List<Referencia> listarRefPorContratante(String codigo);
	
	public List<Referencia> listarPorContratante(long codigo);
	
}
