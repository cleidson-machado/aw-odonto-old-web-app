package br.com.odontoclinic.autenticacao;

import java.io.Serializable;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.com.odontoclinic.model.base.usuario.Usuario;
import br.com.odontoclinic.stuff.usuario.UsuarioRN;
import br.com.odontoclinic.util.HibernateUtil;

public class UsuarioDAOTeste implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static Session sessao;
	private static Transaction transacao;
	
	@BeforeClass
	public static void abreConexao() {
		sessao = HibernateUtil.getSessionFactory().getCurrentSession();
		transacao = sessao.beginTransaction();
	}
	
	//######################
	
	//MÉTODO MAIS SIMPLES UTILIZADO APENAS QUANDO NÃO HAVIA NECESSIDADE DE SALVAR SENHA CRIPTOGRAFADA...
	@Test
	@Ignore
	public void salvar(){
		
		Usuario usuario = new Usuario();
		
		usuario.setAtivo(true);
		usuario.setSenha("12345678");
		usuario.setCpf("608.371.101-06");
		usuario.setTipo("A");
		
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(usuario);
		
		System.out.println("Usuario de teste Salvo com Sucesso!");
		
	}
	
	//USADO PARA CRIAR USUARIO INICIAL DEPOIS DE DELETADO O BANCO POR COMPLETO
	@Test
	//@Ignore
	public void salvarPassCripto(){
		
		Usuario usuario = new Usuario();
		
		usuario.setAtivo(true);
		usuario.setNome("User Base");
		usuario.setSenhaSemCriptografia("123");
		usuario.setCpf("608.371.101-06");
		usuario.setTipo("A");
		
		SimpleHash hash = new SimpleHash("md5", usuario.getSenhaSemCriptografia());
		usuario.setSenha(hash.toHex());
		
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(usuario);
		
		System.out.println("Usuario de teste Salvo com Sucesso!");
		
	}
	
	@Test
	@Ignore
	public void autenticar(){
		String cpf = "608.371.101.06";
		String senha = "123";
		
		UsuarioRN usuarioRN = new UsuarioRN();
		
		Usuario usuario = usuarioRN.autenticar(cpf, senha);
		
		System.out.println("Usuario autenticado:" + usuario);
	}
	
	//#####################
	
	@AfterClass
	public static void fechaConexao() {

		try {

			transacao.commit();

		} catch (Throwable e) {
			System.out.println("deu problema no commit : " + e.getMessage());
		} finally {
			try {
				if (sessao.isOpen()) {
					sessao.close();
				}
			} catch (Exception e2) {
				System.out.println("Deu erro no fechamanto da sessão" + e2.getMessage());
			}
		}
	}
	
}