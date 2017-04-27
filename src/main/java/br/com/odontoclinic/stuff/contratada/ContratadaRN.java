package br.com.odontoclinic.stuff.contratada;

import java.util.List;

import br.com.odontoclinic.model.base.contratada.Contratada;
import br.com.odontoclinic.util.DAOFactory;

public class ContratadaRN {
	
	private ContratadaDAO contratadaDAO;
	
	public ContratadaRN() {
		this.contratadaDAO = DAOFactory.criarContratadaDAO();
	}

	public ContratadaDAO getContratadaDAO() {
		return contratadaDAO;
	}
	
	public void setContratadaDAO(ContratadaDAO contratadaDAO) {
		this.contratadaDAO = contratadaDAO;
	}
	
	//MÉTODOS PADRÃO...	
	public void salvar(Contratada contratada){
		this.contratadaDAO.salvar(contratada);
	}
	
	public void editar(Contratada contratada){
		this.contratadaDAO.editar(contratada);
	}
	
	public void excluir (Contratada contratada){
		this.contratadaDAO.excluir(contratada);
	}
	
	public List<Contratada> listagem(){
		return this.contratadaDAO.listarTodos();
	}
	
	public Contratada carregar (Long codigo){
		return this.contratadaDAO.carregar(codigo);
	}

}
