package br.com.odontoclinic.controller.usuario;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.odontoclinic.model.base.usuario.Usuario;
import br.com.odontoclinic.stuff.usuario.UsuarioRN;

@ManagedBean
@SessionScoped
public class AutenticacaoBean {
	
	private Usuario usuario;
	private Usuario usuarioLogado;
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	@PostConstruct
	public void iniciar(){
		usuario = new Usuario();
	}
	
	//MÉTODO BASE PARA AUTENTICAÇÃO...TRABALHAR MELHOR POIS NÃO ATUALIZA... AS...
	//AS Mensagens DE AVISO NA VIEW DE LOGIN...
	public void autenticar(){
		try {
			
			UsuarioRN usuarioRN = new UsuarioRN();
			usuarioLogado = usuarioRN.autenticar(usuario.getCpf(), usuario.getSenha());
			
			if (usuarioLogado == null) {
				//O Messages não funciona aqui..! Entenda depois o porque disso!
				//Messages.addGlobalError("CPF e/ou Senha Inválidos!");
				
				//FAÇA UM REDIRECT PARA OUTRA PÁGINA COM AVISOS DE CPF OU SENHA INCORRETOS...
			
			} else {
				Messages.addFlashGlobalInfo("Usuário Autenticado com Sucesso!");				
			
			Faces.redirect("./Default.xhtml");
			}
			
		} catch (IOException erro) {
			erro.printStackTrace();
			Messages.addGlobalError("Erro ao tentar a autenticação!" + erro.getMessage());
		}
		
	}
	
	public String sair(){
		usuarioLogado = null;
		return "/pages/autenticacao.xhtml?faces-redirect=true";
	}

}
