package br.com.odontoclinic.stuff.gestudo.assunto;

import java.util.List;

import br.com.odontoclinic.model.base.gestudo.Assunto;
import br.com.odontoclinic.util.DAOFactory;

public class AssuntoRN {
	
	private AssuntoDAO assuntoDAO;

	public AssuntoRN() {
		this.assuntoDAO = DAOFactory.criarAssuntoDAO();
	}
	
	public AssuntoDAO getAssuntoDAO() {
		return assuntoDAO;
	}

	public void setAssuntoDAO(AssuntoDAO assuntoDAO) {
		this.assuntoDAO = assuntoDAO;
	}
	
	//MÉTODOS PADRÃO...
	public void salvar (Assunto assunto) {
		this.assuntoDAO.salvar(assunto);
	}
	
	public void editar (Assunto assunto) {
		this.assuntoDAO.editar(assunto);
	}
	
	public void excluir (Assunto assunto) {
		this.assuntoDAO.excluir(assunto);
	}
	
	public List<Assunto> listagem(){
		return this.assuntoDAO.listarTodos();
	}
	
	public Assunto carregar (Long codigo) {
		return this.assuntoDAO.carregar(codigo);
	}
	
	//MÉTODOS PERSONALIZADOS

}
