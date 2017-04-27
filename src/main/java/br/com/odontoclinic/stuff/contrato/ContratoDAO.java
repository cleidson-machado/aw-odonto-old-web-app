package br.com.odontoclinic.stuff.contrato;

import java.util.List;

import br.com.odontoclinic.model.base.contrato.Contrato;

public interface ContratoDAO {
	
	public void salvar (Contrato contrato);
	public void editar (Contrato contrato);
	public void excluir (Contrato contrato);
	
	public Contrato carregar (Long codigo);
	
	public List<Contrato> listarTodos();

}
