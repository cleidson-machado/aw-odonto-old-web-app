package br.com.odontoclinic.stuff.endereco;

import java.util.Date;
import java.util.List;

import br.com.odontoclinic.model.base.contratante.Contratante;
import br.com.odontoclinic.model.base.endereco.Endereco;
import br.com.odontoclinic.model.base.referencia.Referencia;
import br.com.odontoclinic.util.DAOFactory;

public class EnderecoRN {
	
	private EnderecoDAO enderecoDAO;
	
	public EnderecoRN(){
		this.enderecoDAO = DAOFactory.criarEnderecoDAO();
	}
	
	public EnderecoDAO getEnderecoDAO() {
		return enderecoDAO;
	}
	
	public void setEnderecoDAO(EnderecoDAO enderecoDAO) {
		this.enderecoDAO = enderecoDAO;
	}
	
	// MÉTODOS PADRÃO... E SUAS REGRAS BÁSICAS... ############
	
	//SALVAR para CONTRATANTE
	
	public void salvarEndContratante(Endereco endereco){
		Long codigo = endereco.getCodigo();
		Long contratanteSelecionada = endereco.getContratante().getCodigo();
		
		//SE UMA CONTRATANTE FOR INFORMADA VIA SELECT ONE MENU SALVAR NO BD "Contratante" na coluna Rotulagem
		if (contratanteSelecionada != null) {
			endereco.setRotulagem("Contratante");
		}
		
		//SE O CODIGO FOR IGUAL A NULL O ENDEREÇO É NOVO...
		if (codigo == null || codigo == 0) {
			endereco.setDtaCadastro(new Date());
		
		//SE O CODIGO FOR DIFERENTE DE NULL O ENDEREÇO JÁ ESTAVA NO BANCO...
		} else if (codigo != null || codigo != 0) {
			endereco.setDtaAlteracao(new Date());
		
		} 
			this.enderecoDAO.salvar(endereco);
	}
	
	//SALVAR para REFERENCIA
	public void salvarEndReferencia(Endereco endereco){
		Referencia r = endereco.getReferencia();
		Long referenciaSelecionada = r.getCodigo();

		if (referenciaSelecionada != null) {
			endereco.setRotulagem("Referencia");
		}
		
		//SALVA A DATA DE CADASTRO DO ENDEREÇO
		endereco.setDtaCadastro(new Date());
		this.enderecoDAO.salvar(endereco);
	}
	
	//SALVAR para PACIENTE
	public void salvarEndPaciente(Endereco endereco){
		Contratante p = endereco.getContratante();
		Long pacienteSelecionada = p.getCodigo();

		if (pacienteSelecionada != null) {
			endereco.setRotulagem("Paciente");
		}

		//SALVA A DATA DE CADASTRO DO ENDEREÇO
		endereco.setDtaCadastro(new Date());
		this.enderecoDAO.salvar(endereco);
	}
	
	//EDITAR
	public void editar(Endereco endereco){
		this.enderecoDAO.editar(endereco);
	}
	
	//EXCLUIR
	public void excluir(Endereco endereco){
		this.enderecoDAO.excluir(endereco);
	}
	
	//LISTAR
	public List<Endereco> listagem(){
		return this.enderecoDAO.listarTodos();
	}
	
	// CARREGAR
	public Endereco carregar(Long codigo) {
		return this.enderecoDAO.carregar(codigo);
	}
	
	//PESQUISAR PELO CEP... ESTUDO...
	public List<Endereco> buscaCep(String numCep){
		return this.enderecoDAO.buscarPeloCep(numCep);
	}
	
	//USANDO O LONG
	public List<Endereco> listarPorContratante(long codigo){
		return this.enderecoDAO.listarPorContratante(codigo);
	}
	
	//USANDO O LONG
	public List<Endereco> listarPorReferencia(long codigo){
		return this.enderecoDAO.listarPorReferencia(codigo);
	}

}
