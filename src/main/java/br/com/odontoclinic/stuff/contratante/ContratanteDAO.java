package br.com.odontoclinic.stuff.contratante;

import java.util.List;

import br.com.odontoclinic.model.base.contratante.Contratante;

public interface ContratanteDAO {

	public void salvar (Contratante contratante);
	public void editar (Contratante contratante);
	public void excluir (Contratante contratante);
	
	public Contratante carregar (Long codigo);
	
	public List<Contratante> listarTodos();
	
	public List<Contratante> buscaCpf(String numerocpf);
	
	public Contratante buscaPorCpf(String numCpf);
	
	public int contaPorCpf(String doCpf);
	
	public int contaPorCnpj(String doCnpj);
	
	public boolean cpfJaCadastrado(String doCpf);
	
	public int cpfMaxResultados(String doCpf);
	
	public List<Contratante> listarApenasContratantes();
	
	public List<Contratante> listarApenasPacientes();
	
}
