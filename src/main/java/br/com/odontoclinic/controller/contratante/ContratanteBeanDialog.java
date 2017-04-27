package br.com.odontoclinic.controller.contratante;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ContratanteBeanDialog implements Serializable {

		//USAR O OPEN DIALOG NO COD JAVA É MAIS COMPLEXO POIS ENVOLVE AJAX E O ENVIO E RETORNO DE VÁRIOS
		//OUTROS DETALHES AFINS.. USAR SOMENTE QUANDO FOR NECESSÁRIO E APRENDER EM DETALHES COMO CONSEGUIR
		//OS RETORNOS VIA AJAX E UPDATE DA PÁGINA TANTO AO ABRIR COMO AO FECHAR O DIALOG
	
		public void create() {
			
			Map<String, Object> options = new HashMap<String, Object>();
			options.put("modal", true);
			options.put("resizable", false);
			// opcoes.put("contentHeight", 470); //ajustar quando necessário...
			options.put("contentWidth", 800);

			RequestContext.getCurrentInstance().openDialog("Create", options, null);
		}
		
		public void fecharDialog(){
			//RequestContext context = RequestContext.getCurrentInstance();
			
			//context.update("contratanteListForm:tabela");
			
			RequestContext.getCurrentInstance().closeDialog(null);
		}
	
}
