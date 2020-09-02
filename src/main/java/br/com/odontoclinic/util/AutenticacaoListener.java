package br.com.odontoclinic.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.omnifaces.util.Faces;

import br.com.odontoclinic.controller.usuario.AutenticacaoBean;
import br.com.odontoclinic.model.base.usuario.Usuario;

@SuppressWarnings("serial")
public class AutenticacaoListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent event) {
		String paginaAtual = Faces.getViewId();
		
		boolean ehPaginaDeAutenticacao = paginaAtual.contains("autenticacao.xhtml");
		
		//AQUI VERIFICA-SE SE ESTOU NA TELA PUBLICA OU BLOQUEADA...
		if (!ehPaginaDeAutenticacao) {
			AutenticacaoBean autenticacaoBean = Faces.getSessionAttribute("autenticacaoBean");
			
			//AQUI VERIFICA-SE SE O BEAN DA AUTENTICAÇÃO NUNCA FOI CRIADO
			//OU SEJA RETORNASE PRA TELA DE AUTENTICAÇÃO
			if (autenticacaoBean == null) {
				Faces.navigate("/pages/autenticacao.xhtml");
				return;
			}
			
			//AQUI VERIFICO SE O USUÁRIO LOGADO É TRUE "CARREGADO" OU AUTENTICADO 
			//OU FALSE "NÃO AUTENTICADO" OU SEJA NÃO CARREGADO...
			Usuario usuario = autenticacaoBean.getUsuarioLogado();
			if (usuario == null) {
				Faces.navigate("/pages/autenticacao.xhtml");
				return;
			}
			
		}
	}

	@Override
	public void beforePhase(PhaseEvent event) {		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
		//return PhaseId.ANY_PHASE;
	}

}
