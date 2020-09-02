package br.com.odontoclinic.stuff.usuario;

import java.util.List;

import br.com.odontoclinic.model.base.usuario.Usuario;

public interface UsuarioDAO {
	
	public void salvar (Usuario usuario);
	public void editar (Usuario usuario);
	public void excluir (Usuario usuario);
	
	public Usuario carregar (Long codigo);
	
	public List<Usuario> listarTodos();
	
	public Usuario autenticar(String cpf, String senha);
	
	public void ativaUser(Usuario usuario);
	
	public void desativaUser(Usuario usuario);
	
	public void salvaPasswd(Usuario usuario);
	
	public int contaPorCpf(String doCpf);

}
