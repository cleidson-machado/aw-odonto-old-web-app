package br.com.odontoclinic.controller.usuario;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.omnifaces.util.Messages;

import br.com.odontoclinic.model.base.usuario.Usuario;
import br.com.odontoclinic.regras.validacao.ValidateCpfCnpj;
import br.com.odontoclinic.stuff.usuario.UsuarioRN;
import br.com.odontoclinic.stuff.usuario.UsuarioTipoEnum;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {
	
	private Usuario usuario;
	private List<Usuario> usuarios;
	private UsuarioTipoEnum tipoDoUsuario;
	
	//########################### Enumerador
	public UsuarioTipoEnum[] getLabel(){
		return UsuarioTipoEnum.values();
	}
	
	public UsuarioTipoEnum getTipoDoUsuario() {
		return tipoDoUsuario;
	}
	
	public void setTipoDoUsuario(UsuarioTipoEnum tipoDoUsuario) {
		this.tipoDoUsuario = tipoDoUsuario;
	}
	//########################### Enumerador -----------
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	@PostConstruct
	public void Listar(){
		try {
			
			UsuarioRN usuarioRN = new UsuarioRN();
			usuarios = usuarioRN.listagem();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar listar Usuários");
			erro.printStackTrace();
		}
		
	}
	
	public void novo(){
		try {
			usuario = new Usuario();
			
			UsuarioRN usuarioRN = new UsuarioRN();
			usuarios = usuarioRN.listagem();
			
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao gerar um novo Usuario");
			erro.printStackTrace();
		}
	}
	
	//VALIDAR O CPF NO SALVAMENTO
	//método base... usado apenas no salvamento inicial do usuário... aqui a senha entra como null...
	//MUDAR O NOME DESSE MÉDOTO PRA salvarBtn
	public void salvar(){
		try {
			UsuarioRN usuarioRN = new UsuarioRN();
			usuarioRN.salvar(usuario);
			
			Messages.addFlashGlobalInfo("Ok Usuário SALVO! com sucesso...");
			
			usuario = new Usuario();
			usuarios = usuarioRN.listagem();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar salvar Usuário");
			erro.printStackTrace();
		}
		
	}
	
	//INICIO TESTES PARA A VALIDAÇÃO DO CPF ANTES DE EFETIVAR O PROCESSO DE SALVAMENTO DO USUÁRIO
	
	//VAI SUBSTITUIR O MÉTODO salvar ACIMA... MAS JÁ COM O NOME TROCADO...
	public void salvarBtn(){
		
		if (this.usuario.getCodigo() == null) {
			salvarValidandoUmCpfNovo();
			
		} else if ((this.usuario.getCodigo() != null) && (this.usuario.getCpf() != null)) {
			salvarComCpfJaValidado();
		}
		
	}	
	
	@SuppressWarnings("static-access")
	public void salvarValidandoUmCpfNovo(){
		
		UsuarioRN consulta = new UsuarioRN();
		int qtdCpfDoBanco = consulta.contaPorCpf(this.usuario.getCpf());
		
		String cpfDaView = this.usuario.getCpf();
		ValidateCpfCnpj v = new ValidateCpfCnpj();
		boolean cpfValidacoes = v.validarCPF(cpfDaView);
		
		if (qtdCpfDoBanco == 0) {
			
			if (cpfValidacoes == false) {
				Messages.addFlashGlobalInfo("O CPF  " + cpfDaView + "  é INVÁLIDO!");
				return;
			} else {
				salvar();
			}
			
		} else {
			Messages.addGlobalError("ERRO na criação CPF do USUÁRIO já CADASTRADO!");
				UsuarioRN usuarioRN = new UsuarioRN();
					usuario = new Usuario();
					usuarios = usuarioRN.listagem();
		}

	}
	
	@SuppressWarnings("static-access")
	public void salvarComCpfJaValidado(){

		UsuarioRN consulta = new UsuarioRN();
		int qtdCpfDoBanco = consulta.contaPorCpf(this.usuario.getCpf());

		String cpfDaView = this.usuario.getCpf();
		ValidateCpfCnpj v = new ValidateCpfCnpj();
		boolean cpfValidacoes = v.validarCPF(cpfDaView);

		Usuario cpfdoBanco = consulta.carregar(this.usuario.getCodigo());

		if ( (qtdCpfDoBanco == 0) && (cpfValidacoes == true) ) {
			edicaoBtn();
			return;

		} else if ( (qtdCpfDoBanco == 0) || (cpfValidacoes = false) ) {
			Messages.addFlashGlobalInfo("O CPF  " + cpfDaView + "  é INVÁLIDO!");
				UsuarioRN usuarioRN = new UsuarioRN();
				usuario = new Usuario();
				usuarios = usuarioRN.listagem();
			return;

		} else if ( (qtdCpfDoBanco == 1) && (cpfdoBanco.getCpf().equals( cpfDaView )) ) {
			edicaoBtn();
			return;
			
		} else {
			Messages.addGlobalError("ERRO na edição CPF do USUÁRIO já CADASTRADO!");
				UsuarioRN usuarioRN = new UsuarioRN();
				usuario = new Usuario();
				usuarios = usuarioRN.listagem();
		}
	}
	
	//VALIDAR O CPF NA EDIÇÃO
	//MUDAR O NOME DESSE MÉDOTO PRA editarBtn
	public void edicaoBtn() {
		try {
			UsuarioRN usuarioRN = new UsuarioRN();
			usuarioRN.editar(usuario);
			
			Messages.addFlashGlobalInfo("Ok Usuário EDITADO! com sucesso...");

			usuario = new Usuario();
			usuarios = usuarioRN.listagem();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar Editar Usuário");
			erro.printStackTrace();
		}

	}
	
	//########### FIM DOS TESTES DE VALIDAÇÃO...

	public void salvarPassWd(){
		try {
			String novaSenhaSemCripto = usuario.getNovaSenhaSemCripto();
			String novaSenhaSemCriptoContraprova = usuario.getNovaSenhaSemCriptoContraprova();
			
			if (novaSenhaSemCripto.equals(novaSenhaSemCriptoContraprova)) {
				
				SimpleHash hash = new SimpleHash("md5", usuario.getNovaSenhaSemCripto());
				usuario.setSenha(hash.toHex());
				
				//ativa o usuário ao salvar a senha...
				usuario.setAtivo(true);
				
				UsuarioRN usuarioRN = new UsuarioRN();
				usuarioRN.salvaPasswd(usuario);
				
				Messages.addFlashGlobalInfo("Senha de: " + usuario.getNome() + " " +  usuario.getSobreNome() +  " ALTERADA!");
				
				usuario = new Usuario();
				usuarios = usuarioRN.listagem();
				
			} else {
				Messages.addFlashGlobalInfo("SENHA informada e a CONFIRMAÇÃO estão DIFERENTES!");
			} return;

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar salvar Usuário");
			erro.printStackTrace();
		}
		
	}
	
	public void trocaPasswd(){
		try {
			UsuarioRN consulta = new UsuarioRN();
			Usuario usuarioNoBanco = consulta.carregar(usuario.getCodigo());

			String novaSenhaSemCripto = usuario.getNovaSenhaSemCripto();
			String novaSenhaSemCriptoContraprova = usuario.getNovaSenhaSemCriptoContraprova();
			
			//Pra comparar a senha atual/antiga lembrada pelo user com a do Banco!
			SimpleHash hash2 = new SimpleHash("md5", usuario.getSenhaSemCriptografia());
			String senhaAtualByUserTyped = hash2.toString();

			//Verifica se a senha do banco é igual a senha atual que o usuario já utiliza..
			if ( senhaAtualByUserTyped.equals(usuarioNoBanco.getSenha()) ) {
				//#### se for igual segue o if fluxo abaixo!...
				
				//Para persistir a nova senha confirmada pelo usuário no banco...
				SimpleHash hash1 = new SimpleHash("md5", usuario.getNovaSenhaSemCripto());
				usuario.setSenha(hash1.toHex());

				//verifica se a senha e contraprova são iguais
				if (novaSenhaSemCripto.equals(novaSenhaSemCriptoContraprova)) {

					UsuarioRN usuarioRN = new UsuarioRN();
					usuarioRN.trocaPasswd(usuario);
					
					Messages.addFlashGlobalInfo("Senha de: " + usuario.getNome() + " " +  usuario.getSobreNome() +  " ALTERADA!");
					
					usuario = new Usuario();
					usuarios = usuarioRN.listagem();

				} else if (!novaSenhaSemCripto.equals(novaSenhaSemCriptoContraprova)) {
					Messages.addFlashGlobalInfo("Senha informada e a confirmação são diferentes!");
					return;
				}
			
			//Se NÃO confirmar! a SENHA ATUAL vai parar aqui...
			} else if ( !senhaAtualByUserTyped.equals(usuarioNoBanco.getSenha()) ) {
				Messages.addFlashGlobalWarn("SEM CONFIRMAÇÃO! Você lembra sua SENHA ATUAL," + " " + usuario.getNome() + "?");
				return;
			}

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar alterar a senha do Usuário");
			erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento){
		try {
			usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");
			
			Messages.addFlashGlobalWarn("Usuário: " + usuario.getNome() + " " + usuario.getSobreNome() +  " EXCLUÍDO!");
			
			UsuarioRN usuarioRN = new UsuarioRN();
			usuarioRN.excluir(usuario);
			
			usuarios = usuarioRN.listagem();
			
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar remover Usuário");
			erro.printStackTrace();
		}
		
	}

	//Botão desativado na View se a senha é nula...
	public void resetarPassWd(ActionEvent evento){
		try {
			usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");
			
			Messages.addFlashGlobalWarn("SENHA do Usuário: " + usuario.getNome() + " " + usuario.getSobreNome() +  " RESETADA!");
			
			//salva como null a senha, ou seja anula a senha e inativa o usuário...
			usuario.setSenha(null);
			
			//Desativa o usuário ao Resetar a senha
			usuario.setAtivo(false);
			
			UsuarioRN usuarioRN = new UsuarioRN();
			usuarioRN.trocaPasswd(usuario);
			
		} catch (Exception erro) {
			Messages.addFlashGlobalError("Erro ao tentar RESETAR senha do Usuário");
			erro.printStackTrace();
		}
		
	}

	public void ativaBtn(ActionEvent evento){
		try {
			
			usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");
			
			UsuarioRN usuarioRN = new UsuarioRN();
			usuarioRN.ativaUser(usuario);

			usuarios = usuarioRN.listagem();

			Messages.addFlashGlobalInfo("Usuário: " + usuario.getNome() + " " +  usuario.getSobreNome() +  " ATIVADO!");

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar ativar Usuário");
			erro.printStackTrace();
		}
		
	}
	
	public void desativaBtn(ActionEvent evento){
		try {
			
			usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");

			UsuarioRN usuarioRN = new UsuarioRN();
			usuarioRN.desativaUser(usuario);

			usuarios = usuarioRN.listagem();

			Messages.addFlashGlobalWarn("Usuário: " + usuario.getNome() + " " +  usuario.getSobreNome() +  " DESATIVADO!");

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar desativar Usuário");
			erro.printStackTrace();
		}
		
	}
	
	public void editar(ActionEvent evento){

		usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");

	}

}
