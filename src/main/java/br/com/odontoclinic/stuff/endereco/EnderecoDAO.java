package br.com.odontoclinic.stuff.endereco;

import java.util.List;

import br.com.odontoclinic.model.base.endereco.Endereco;

public interface EnderecoDAO {
	
	public void salvar (Endereco endereco);
	public void editar (Endereco endereco);
	public void excluir (Endereco endereco);
	
	public Endereco carregar (Long codigo);
	
	public List<Endereco> listarTodos();
	
	public List<Endereco> buscarPeloCep(String numCep);
	
	public List<Endereco> listarPorContratante(long codigo);
	
	public List<Endereco> listarPorReferencia(long codigo);

}
