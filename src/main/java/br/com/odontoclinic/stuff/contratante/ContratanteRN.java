package br.com.odontoclinic.stuff.contratante;


import java.util.Date;
import java.util.List;

import br.com.odontoclinic.model.base.contratante.Contratante;
import br.com.odontoclinic.util.DAOFactory;

public class ContratanteRN {

	private ContratanteDAO contratanteDAO;

	public ContratanteRN(){
		this.contratanteDAO = DAOFactory.criarContratanteDAO();
	}
	
	public ContratanteDAO getContratanteDAO() {
		return contratanteDAO;
	}

	public void setContratanteDAO(ContratanteDAO contratanteDAO) {
		this.contratanteDAO = contratanteDAO;
	}
	
	// MÉTODOS PADRÃO... E SUAS REGRAS BÁSICAS... ############
	
	//############################################################################################
	//SALVAR PACIENTE...
		public void salvarPaciente(Contratante contratante){
			
			//A Paciente é mais simplificada não há validação de CPF por exemplo..
			//Está verificando na Bean se é um registro novo.. então não vou usa-lá..
			//só entra aqui se for uma nova paciente...
			contratante.setDtaCadastro(new Date());
			contratante.setContratanteStatus("ATIVO");
			contratante.setTipo(null);
			contratante.setCamada("pa");
			contratante.setNativo("PACIENTE");
			
			this.contratanteDAO.salvar(contratante);
		}
	//############################################################################################
	
	//SALVAR OU EDITAR PACIENTE... com camada funcional PA no banco...
	public void salvarPa(Contratante contratante){
		Long codigo = contratante.getCodigo();
		
		//SE for um novo registro salva as Marcações típicas de paciente...
		if (codigo == null|| codigo == 0) {
			contratante.setDtaCadastro(new Date());
			
			contratante.setContratanteStatus("ATIVO");
			contratante.setTipo(null);
			contratante.setCamada("pa");
			contratante.setNativo("PACIENTE");
			
			this.contratanteDAO.salvar(contratante);
		
		//SE for um registro já existente apenas edita..
		} else if (codigo != null || codigo!= 0) {

			this.contratanteDAO.editar(contratante);
		}
		
	}
	
	//SALVAR OU EDITAR CONTRATANTE/PACIENTE ... copa!!
	public void salvarCopa(Contratante contratante){
		//A Contratante/Paciente já é um registro formado no BD então será sempre uma edição...
		contratante.setPai(null);
		this.contratanteDAO.editar(contratante);
	}
	
	//SALVAR OU EDITAR TRANSFORMANDO DE PACIENTE/CONTRATANTE ... copa!!
	public void salvarCopaPaciente(Contratante contratante){
		contratante.setCamada("copa");
		contratante.setTipo("FISICA");
		contratante.setDtaMudaCamada(new Date());
		this.contratanteDAO.editar(contratante);
	}
	
	//SALVAR
	public void salvar(Contratante contratante){
		
		Long codigo = contratante.getCodigo();
		String cnpjInformado = contratante.getCnpj();
		
		//Para Cadastros novos... que trazem por padrão apenas o CPF
		if (codigo == null || codigo == 0) {
			
			contratante.setContratanteStatus("ATIVO");
			contratante.setTipo("FISICA");
			contratante.setCamada("co");
			contratante.setNativo("CONTRATANTE");
			
			contratante.setDtaCadastro(new Date());
				this.contratanteDAO.salvar(contratante);
			
			return;
		}
	
		//Para Cadastros já existentes...
		if (codigo != null || codigo != 0) {
			
			//Se informar o CNPJ edita como Jurídica
			if (cnpjInformado != null) {
				contratante.setTipo("JURIDICA");
				
			}
			
				this.contratanteDAO.editar(contratante);
				
			return;
		}
		
	}
	
	//EDITAR
	public void editar(Contratante contratante){
		
		Long codigo = contratante.getCodigo();
		String cnpjInformado = contratante.getCnpj();
		
		if ((codigo != null) && (cnpjInformado != null)) {
			
			contratante.setTipo("JURIDICA");
			this.contratanteDAO.editar(contratante);
			
		}
		
		this.contratanteDAO.editar(contratante);
	}
	
	//EXCLUIR
	public void excluir(Contratante contratante){
		this.contratanteDAO.excluir(contratante);
	}
	
	//ATUALIZAR APENAS O CNPJ PARA NULL... E MUDAR O STATUS...
	public void excluirCnpj(Contratante contratante) {
		contratante.setCnpj(null);
		contratante.setTipo("FISICA");
		this.contratanteDAO.editar(contratante);
	}

	//LISTAR
	public List<Contratante> listagem(){
		return this.contratanteDAO.listarTodos();
	}
	
	//CARREGAR
	public Contratante carregar(Long codigo){
		return this.contratanteDAO.carregar(codigo);
	}
	
	//ESTUDO.. NÃO USADO NO PROJETO
	public List<Contratante> validaTemCpf(String numerocpf){
		return this.contratanteDAO.buscaCpf(numerocpf);
	}
	
	//ESTUDO.. NÃO USADO NO PROJETO
	public Contratante buscarPorCpf(String doCpf){
		return this.contratanteDAO.buscaPorCpf(doCpf);
	}
	
	//USADO NA VERIFICAÇÃO DE EXISTÊNCIA OU NÃO DO CPF
	public int contagemCpf(String doCpf){
		return this.contratanteDAO.contaPorCpf(doCpf);
	}
	
	//USADO NA VERIFICAÇÃO DE EXISTÊNCIA OU NÃO DO CNPJ
	public int contagemCnpj(String doCnpj){
		return this.contratanteDAO.contaPorCnpj(doCnpj);
	}
	
	//criado para comparações entre o cpf da view com a do banco...
	public boolean cpfJaCadastrado(String doCpf){
		return this.contratanteDAO.cpfJaCadastrado(doCpf);
	}
	
	//criado para comparações entre o cpf da view com a do banco...
	public int testaMetDois (String doCpf){
		return this.contratanteDAO.cpfMaxResultados(doCpf);
	}
	
	//Para listar apenas Contratantes... Usar DataTable e ou SelectOneMenus
	public List<Contratante> listarApenasContratantes(){
		return this.contratanteDAO.listarApenasContratantes();
	}
	
	//Para listar apenas Pacientes... Usar DataTable e ou SelectOneMenus
	public List<Contratante> listarApenasPacientes(){
		return this.contratanteDAO.listarApenasPacientes();
	}
	
}