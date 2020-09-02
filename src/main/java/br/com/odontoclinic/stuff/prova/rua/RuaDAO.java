package br.com.odontoclinic.stuff.prova.rua;

import java.util.List;

import br.com.odontoclinic.model.base.prova.Rua;

public interface RuaDAO {
	
	public void salvar (Rua rua);
	public void ediar (Rua rua);
	public void excluir (Rua rua);
	
	public Rua carregar (Long codigo);
	
	public List<Rua> listarTodos();
	
	//aqui está incorreto pra uso na been..
	public int contaContribuinteXRua(Long codigo);
	
	//Teste contagem rua por contribuinte...
	public List<Rua> listarQtdRuaPorContribuinte(String codigo);
	
	//Testes....
	public List<Rua> listarTesteHql();

}
