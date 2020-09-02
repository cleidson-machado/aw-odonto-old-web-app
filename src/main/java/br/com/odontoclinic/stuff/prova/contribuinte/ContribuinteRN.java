package br.com.odontoclinic.stuff.prova.contribuinte;

import java.util.List;

import br.com.odontoclinic.model.base.prova.Contribuinte;
import br.com.odontoclinic.util.DAOFactory;

public class ContribuinteRN {
	
	private ContribuinteDAO contribuinteDAO;
	
	public ContribuinteRN() {
		this.contribuinteDAO = DAOFactory.criarContribuinteDAO();
	}

	public ContribuinteDAO getContribuinteDAO() {
		return contribuinteDAO;
	}

	public void setContribuinteDAO(ContribuinteDAO contribuinteDAO) {
		this.contribuinteDAO = contribuinteDAO;
	}
	
	//MÉTODOS PADRÃO...
	public void salvar(Contribuinte contribuinte) {	
		this.contribuinteDAO.salvar(contribuinte);
	}
	
	public void editar(Contribuinte contribuinte) {
		this.contribuinteDAO.editar(contribuinte);
	}
	
	public void excluir(Contribuinte contribuinte) {
		this.contribuinteDAO.excluir(contribuinte);
	}
	
	public List<Contribuinte> listagem(){
		return this.contribuinteDAO.listarTodos();
	}
	
	public Contribuinte carregar (Long codigo) {
		return this.contribuinteDAO.carrregar(codigo);
	}
	//MÉTODOS PADRÃO... FIM ################

	public List<Contribuinte> listagemRuasPorContribuinte(long codigo) {
		return this.contribuinteDAO.listadoPorRua(codigo);
	}

}
