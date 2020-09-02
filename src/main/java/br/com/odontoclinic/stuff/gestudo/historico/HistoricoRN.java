package br.com.odontoclinic.stuff.gestudo.historico;

import java.util.List;

import br.com.odontoclinic.model.base.gestudo.Historico;
import br.com.odontoclinic.util.DAOFactory;

public class HistoricoRN {
	
	private HistoricoDAO historicoDAO;
	
	public HistoricoRN() {
		this.historicoDAO = DAOFactory.criarHistoricoDAO();
	}

	public HistoricoDAO getHistoricoDAO() {
		return historicoDAO;
	}

	public void setHistoricoDAO(HistoricoDAO historicoDAO) {
		this.historicoDAO = historicoDAO;
	}
	
	//MÉTODOS PADRÃO...
	public void salvar (Historico historico) {
		this.historicoDAO.salvar(historico);
	}
	
	public void editar (Historico historico) {
		this.historicoDAO.editar(historico);
	}
	
	public void excluir (Historico historico) {
		this.historicoDAO.excluir(historico);
	}
	
	public List<Historico> listagem(){
		return this.historicoDAO.listarTodos();
	}
	
	public Historico carregar (Long codigo) {
		return this.historicoDAO.carregar(codigo);
	}
	
	//MÉTODOS PERSONALIZADOS

}
