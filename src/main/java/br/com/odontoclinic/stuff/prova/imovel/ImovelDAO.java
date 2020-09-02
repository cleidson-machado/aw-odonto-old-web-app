package br.com.odontoclinic.stuff.prova.imovel;

import java.util.List;

import br.com.odontoclinic.model.base.prova.Imovel;

public interface ImovelDAO {
	
	public void salvar (Imovel imovel);
	public void editar (Imovel imovel);
	public void excluir (Imovel imovel);
	
	public Imovel carregar (Long codigo);
	
	public List<Imovel> listarTodos();
	
	public List<Imovel> listadoPorContribuinte(long codigo);
	
	//BUSCAS1...
	public List<Imovel> listagemZeroContribuinte();
	
	//BUSCAS2...
	public List<Imovel> listagemAlgumContribuinte();
	
	//BUSCAS4...
	public List<Imovel> listagemContratantePorNome(String doNome);

}
