package br.com.odontoclinic.stuff.referencia;

import java.util.List;

import br.com.odontoclinic.model.base.referencia.Referencia;
import br.com.odontoclinic.util.DAOFactory;

public class ReferenciaRN {

	private ReferenciaDAO referenciaDAO;
	
	public ReferenciaRN(){
		this.referenciaDAO = DAOFactory.criarReferenciaDAO();
	}
	
	public ReferenciaDAO getReferenciaDAO() {
		return referenciaDAO;
	}

	public void setReferenciaDAO(ReferenciaDAO referenciaDAO) {
		this.referenciaDAO = referenciaDAO;
	}

	//SALVAR
	public void salvar(Referencia referencia){
		this.referenciaDAO.salvar(referencia);
	}
	
	//EDITAR
	public void editar(Referencia referencia){
		this.referenciaDAO.editar(referencia);
	}
	
	//EXCLUIR
	public void excluir(Referencia referencia){
		this.referenciaDAO.excluir(referencia);
	}
	
	//LISTAR
	public List<Referencia> listagem(){
		return this.referenciaDAO.listarTodos();
	}	
	
	//ESTUDO... NÃO USADO NO PROJETO...
	//LISTAR TODAS AS REFERENCIAS POR DETERMINADA CONTRATANTE...
	public List<Referencia> listaRefPorContratante(String codigo){
		return this.referenciaDAO.listarRefPorContratante(codigo);
	}
	
	//USANDO O LONG
	//LISTAR TODAS AS REFERENCIAS POR DETERMINADA CONTRATANTE...
	public List<Referencia> listaRefContratante(long codigo){
		return this.referenciaDAO.listarPorContratante(codigo);
	}
}