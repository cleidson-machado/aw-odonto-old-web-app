package br.com.odontoclinic.stuff.usuario;

import java.util.Date;
import java.util.List;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.odontoclinic.model.base.usuario.Usuario;

public class UsuarioDAOHibernate implements UsuarioDAO {
	
	private Session session;

	public void setSession(Session session){
		this.session = session;
	}
	
	@Override
	public void salvar(Usuario usuario) {
		usuario.setDtaCadastro(new Date());
		usuario.setAtivo(false);
		
		this.session.saveOrUpdate(usuario);
		
	}
	
	//AQUI A DATA DE CRIAÇÃO DA SENHA É GRAVADA
	@Override
	public void salvaPasswd(Usuario usuario){
		
		Usuario dataCadastral = this.carregar(usuario.getCodigo());
		usuario.setDtaCadastro(dataCadastral.getDtaCadastro());
		usuario.setDtaCriaSenha(new Date());
		
		this.session.evict(dataCadastral);
		
		this.session.update(usuario);
		
	}

	//AQUI FAZ Update e PRESERVA AS DATAS...
	@Override
	public void editar(Usuario usuario) {
		
		Usuario dataCadastral = this.carregar(usuario.getCodigo());
		usuario.setDtaCadastro(dataCadastral.getDtaCadastro());
		usuario.setDtaCriaSenha(dataCadastral.getDtaCriaSenha());
		
		this.session.evict(dataCadastral);
		
		this.session.update(usuario);
	}

	@Override
	public void excluir(Usuario usuario) {
		this.session.delete(usuario);
		
	}

	@Override
	public Usuario carregar(Long codigo) {
		return (Usuario) this.session.get(Usuario.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listarTodos() {
		return this.session.createCriteria(Usuario.class).list();
	}
	
	@Override
	public Usuario autenticar(String cpf, String senha){
		
		Criteria consulta = session.createCriteria(Usuario.class);
		
		//CONVERTE A SENHA PRA HASH AQUI.. para consultas..
		SimpleHash hash = new SimpleHash("md5", senha);
		consulta.add(Restrictions.eq("senha", hash.toHex()));
		
		// SEGUNDA CONSULTA...
		consulta.add(Restrictions.eq("Cpf", cpf));
		
		Usuario resultado = (Usuario) consulta.uniqueResult();
		
		return resultado;
	}

	@Override
	public void ativaUser(Usuario usuario) {
		
		Usuario dataCadatral = this.carregar(usuario.getCodigo());
		usuario.setDtaCadastro(dataCadatral.getDtaCadastro());
		
		this.session.evict(dataCadatral);
		
		usuario.setAtivo(true);
		
		this.session.update(usuario);
		
	}

	@Override
	public void desativaUser(Usuario usuario) {
		
		Usuario dataCadatral = this.carregar(usuario.getCodigo());
		usuario.setDtaCadastro(dataCadatral.getDtaCadastro());
		
		this.session.evict(dataCadatral);
		
		usuario.setAtivo(false);
		
		this.session.update(usuario);
		
	}

	//MÉTODOS ESPECIALIZADOS DE PESQUISA NO BANCO DE DADOS...

	@Override
	public int contaPorCpf(String doCpf){
		String hql = "SELECT u FROM Usuario u WHERE u.Cpf LIKE :pesqdoCpf";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("pesqdoCpf", doCpf);
		return consulta.list().size();
	}

}
