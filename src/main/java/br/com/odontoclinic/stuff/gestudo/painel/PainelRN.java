package br.com.odontoclinic.stuff.gestudo.painel;

import java.util.List;

import br.com.odontoclinic.model.base.gestudo.Cliente;
import br.com.odontoclinic.model.base.gestudo.Painel;
import br.com.odontoclinic.model.base.usuario.Usuario;
import br.com.odontoclinic.util.DAOFactory;

public class PainelRN {

	private PainelDAO painelDAO;
	
	public PainelRN() {
		this.painelDAO = DAOFactory.criarPainelDAO();
	}

	public PainelDAO getPainelDAO() {
		return painelDAO;
	}

	public void setPainelDAO(PainelDAO painelDAO) {
		this.painelDAO = painelDAO;
	}
	
	//MÉTODOS PADRÃO...
	public void salvar (Painel painel) {
		//painel.setOriginal(true);
		this.painelDAO.salvar(painel);
	}
	
	public void editar (Painel painel) {
		this.painelDAO.editar(painel);
	}
	
	public void excluir (Painel painel) {
		this.painelDAO.excluir(painel);
	}
	
	public List<Painel> listagem(){
		return this.painelDAO.listarTodos();
	}
	
	public Painel carregar (Long codigo) {
		return this.painelDAO.carregar(codigo);
	}
	
	//MÉTODOS PERSONALIZADOS #########################################

	//######## VERIFICADO
	//LISTAGEM APENAS DE ITENS ORIGINAIS DE PAINEL..
	public List<Painel> listOriginalIn() {
		return this.painelDAO.listOriginalIn();
	}

	//######## VERIFICADO
	//LISTAGEM APENAS DE ITENS (( NÃO )) ORIGINAIS DE PAINEL..
	public List<Painel> listAllNotOriginalIn(){
		return this.painelDAO.listAllNotOriginalIn();
	}

	//######## VERIFICADO
	//LISTA APENAS O PRIMEIRO ITEN (( NÃO )) ORIGINAL DE PAINEL..
	public List<Painel> listTheFirstOneNotOriginalIn(){
		return this.painelDAO.listTheFirstOneNotOriginalIn();
	}
	
	//######## VERIFICADO
	//LISTA TODOS OS TICKTS ASSUMIDOS NO PAINEL
	public List<Painel> listAllTicketsAssumidos(){
		return this.painelDAO.listAllTicketsAssumidos();
	}
	
	//USADO NO LISTDIALOG DO PAINEL PARA TICKETS
	public void editarPainelTK (Painel painel) {
		
			Long IdClienteNoPainelTicket = painel.getCliente().getCodigo();
			
			Long IdUsuarioNoPainelTicket = painel.getUsuario().getCodigo();
			
			//Long IdAssuntoNoPainelTicket = painel.getAssunto().getCodigo();
			
			Cliente cliente = new Cliente();
			cliente.setCodigo(IdClienteNoPainelTicket);
			
			Usuario usuario = new Usuario();
			usuario.setCodigo(IdUsuarioNoPainelTicket);
			
			//Assunto assunto = new Assunto();
			//assunto.setCodigo(IdAssuntoNoPainelTicket);
			
			//JÁ DEFINIDOS AO CRIAR OS PAINEIS/TICKETS NO CONCEITO DA PROPOSTA DE USO...
			//painel.setUsuario(usuario);
			
			//painel.setCliente(cliente);
			
			//painel.setAssunto(assunto);
			
			System.out.println("DO USUARIO" + usuario);
			
			System.out.println("DO CLIENTE" + cliente);
			
			painel.setStatusFlag("GRE");
			
			painel.setTipoAtendimento("ASSUMIDO");
			
			painel.setActionOnDemand("EM ATENDIMENTO");
			
			painel.setContatoNome(painel.getNome());
		
			painel.setStatusFinalizado("ATEND");
			painel.setResumoChamadoAtual(painel.getTxtRecado());
			
			painel.setItemObservacaoAlerta(true);
			
			//IMPORTANTE... MANTER OS PAINEL/TICKET SEMPRE COM ORIGINAL FALSE...
			painel.setOriginal(false);
			
		this.painelDAO.editar(painel);
	}
	
}
