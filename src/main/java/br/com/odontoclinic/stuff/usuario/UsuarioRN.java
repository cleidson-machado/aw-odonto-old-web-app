package br.com.odontoclinic.stuff.usuario;

import java.util.List;

import br.com.odontoclinic.model.base.usuario.Usuario;
import br.com.odontoclinic.util.DAOFactory;

public class UsuarioRN {
	
	private UsuarioDAO usuarioDAO;

	public UsuarioRN() {
		this.usuarioDAO = DAOFactory.criarUsuarioDAO();
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	//MÉTODOS PADRÃO...	
	public void salvar(Usuario usuario){
		this.usuarioDAO.salvar(usuario);
	}

	public void editar(Usuario usuario){
		this.usuarioDAO.editar(usuario);
	}

	public void excluir(Usuario usuario){
		this.usuarioDAO.excluir(usuario); 
	}

	public List<Usuario> listagem(){
		return this.usuarioDAO.listarTodos();
	}

	public Usuario carregar (Long codigo){
		return this.usuarioDAO.carregar(codigo);
	}
	
	//MÉTODOS PERSONALIZADOS
	public Usuario autenticar(String cpf, String senha){
		return this.usuarioDAO.autenticar(cpf, senha);
	}

	public void ativaUser(Usuario usuario) {
		this.usuarioDAO.ativaUser(usuario); 
		
	}
	
	public void desativaUser(Usuario usuario) {
		this.usuarioDAO.desativaUser(usuario); 
		
	}
	
	public void salvaPasswd(Usuario usuario){
		this.usuarioDAO.salvaPasswd(usuario);
		
	}
	
	//CHECAGEM NA TROCA DE SENHA? AQUI?
	public void trocaPasswd(Usuario usuario){
		this.usuarioDAO.editar(usuario);
		
	}

	//USADO NA VERIFICAÇÃO DE EXISTÊNCIA OU NÃO DO CPF
	public int contaPorCpf(String doCpf){
		return this.usuarioDAO.contaPorCpf(doCpf);
	}
	
}
