package br.com.odontoclinic.stuff.prova.imovel;

import java.util.List;

import br.com.odontoclinic.model.base.prova.Imovel;
import br.com.odontoclinic.util.DAOFactory;

public class ImovelRN {
	
	private ImovelDAO imovelDAO;
	
	public ImovelRN() {
		this.imovelDAO = DAOFactory.criarImovelDAO();
	}

	public ImovelDAO getImovelDAO() {
		return imovelDAO;
	}

	public void setImovelDAO(ImovelDAO imovelDAO) {
		this.imovelDAO = imovelDAO;
	}
	
	//MÉTODOS PADRÃO...
	public void salvar(Imovel imovel) {
		
		String daZona;
		daZona = imovel.getZona();
		
		String doSetor;
		doSetor = imovel.getSetor();
		
		String daQuadra;
		daQuadra = imovel.getQuadra();
		
		String doLote;
		doLote = imovel.getLote();
		
		//SALVAR COMIMOV OU SEMIMOV
		//no campo Tipo da Contribuinte
	
		imovel.setInscricao(daZona + doSetor + daQuadra + doLote);
		
		this.imovelDAO.salvar(imovel);
	}
	
	public void editar(Imovel imovel) {
		this.imovelDAO.editar(imovel); 
	}
	
	public void excluir(Imovel imovel) {
		this.imovelDAO.excluir(imovel);
	}
	
	public List<Imovel> listagem(){
		return this.imovelDAO.listarTodos();
	}
	
	public Imovel carregar (Long codigo) {
		return this.imovelDAO.carregar(codigo);
	}
	//MÉTODOS PADRÃO... FIM ################

	public List<Imovel> listagemImoveisPorContribuinte(long codigo) {
		return this.imovelDAO.listadoPorContribuinte(codigo);
	}

	//BUSCAS1...
	public List<Imovel> listarImovelZeroContribuinte() {
		return this.imovelDAO.listagemZeroContribuinte();
	}
	
	//BUSCAS2...
	public List<Imovel> listarImovelAlgumContribuinte() {
		return this.imovelDAO.listagemAlgumContribuinte();
	}

	public List<Imovel> buscarNomeContratante(String doNome) {
		return this.imovelDAO.listagemContratantePorNome(doNome);
	}

}
