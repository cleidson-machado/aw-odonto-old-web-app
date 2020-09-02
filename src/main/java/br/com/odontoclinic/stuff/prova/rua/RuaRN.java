package br.com.odontoclinic.stuff.prova.rua;

import java.util.Date;
import java.util.List;

import br.com.odontoclinic.model.base.prova.Rua;
import br.com.odontoclinic.util.DAOFactory;

public class RuaRN {
	
	private RuaDAO ruaDAO;
	
	public RuaRN() {
		this.ruaDAO = DAOFactory.criarRuaDAO();
	}

	public RuaDAO getRuaDAO() {
		return ruaDAO;
	}

	public void setRuaDAO(RuaDAO ruaDAO) {
		this.ruaDAO = ruaDAO;
	}
	
	//MÉTODOS PADRÃO...
	public void salvar(Rua rua) {
		rua.setDtaCadastro(new Date());
		this.ruaDAO.salvar(rua);
	}
	
	public void editar(Rua rua) {
		this.ruaDAO.ediar(rua);
	}
	
	public void excluir(Rua rua) {
		this.ruaDAO.excluir(rua);
	}
	
	public List<Rua> listagem(){
		return this.ruaDAO.listarTodos();
	}
	
	public Rua carregar (Long codigo) {
		return this.ruaDAO.carregar(codigo);
	}
	//MÉTODOS PADRÃO... FIM ################
	
	
	//Teste contagem rua por contribuinte...
	public List<Rua> listagemTeste(String codigo){
		return this.ruaDAO.listarQtdRuaPorContribuinte(codigo);
	}
	
	//testes...
	public List<Rua> listagemSimplesHql(){
		return this.ruaDAO.listarTesteHql();
	}
	
	@SuppressWarnings("unused")
	public String qtdRuaPorcontrib(Rua rua) {
			
		//PENSAR!!!!?????
		
		long kkk;
		kkk = rua.getCodigo();
		
		//return this.ruaDAO.contaContribuinteXRua(codigo);
		return null;
	}

	
}
