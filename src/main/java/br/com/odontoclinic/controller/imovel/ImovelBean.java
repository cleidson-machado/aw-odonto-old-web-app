package br.com.odontoclinic.controller.imovel;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.odontoclinic.model.base.prova.Contribuinte;
import br.com.odontoclinic.model.base.prova.Imovel;
import br.com.odontoclinic.stuff.prova.imovel.ImovelRN;

import br.com.odontoclinic.stuff.prova.imovel.LoteENUM;
import br.com.odontoclinic.stuff.prova.imovel.QuadraENUM;
import br.com.odontoclinic.stuff.prova.imovel.SetorENUM;
import br.com.odontoclinic.stuff.prova.imovel.ZonasENUM;

@SuppressWarnings("serial")
@ManagedBean(name="dtContextImovelView")
@ViewScoped
public class ImovelBean implements Serializable {
	
	private Imovel imovel;
	private List<Imovel> imoveis;
	private Contribuinte contribuinte;
	
	//teste nova lista para menu de contexto
	private Imovel imovelSelecionado;
	
	private ZonasENUM zonaENUM;
	private SetorENUM setorENUM;
	private QuadraENUM quadraENUM;
	private LoteENUM loteENUM;
	
	//ZONA #################################
	public ZonasENUM[] getLabel1() {
		return ZonasENUM.values();
	}
	
	public ZonasENUM getZonaENUM() {
		return zonaENUM;
	}
	
	public void setZonaENUM(ZonasENUM zonaENUM) {
		this.zonaENUM = zonaENUM;
	}
	
	//SETOR #################################
	public SetorENUM[] getLabel2() {
		return SetorENUM.values();
	}
	
	public SetorENUM getSetorENUM() {
		return setorENUM;
	}
	
	public void setSetorENUM(SetorENUM setorENUM) {
		this.setorENUM = setorENUM;
	}
	
	//QUADRA #################################
	public QuadraENUM[] getLabel3() {
		return QuadraENUM.values();
	}
	
	public QuadraENUM getQuadraENUM() {
		return quadraENUM;
	}
	
	public void setQuadraENUM(QuadraENUM quadraENUM) {
		this.quadraENUM = quadraENUM;
	}
	
	//LOTE #################################
	public LoteENUM[] getLabel4() {
		return LoteENUM.values();
	}
	
	public LoteENUM getLoteENUM() {
		return loteENUM;
	}
	
	public void setLoteENUM(LoteENUM loteENUM) {
		this.loteENUM = loteENUM;
	}
	//FIM DOS ENUNs...
	//###################################################################################################
	
	public Imovel getImovel() {
		return imovel;
	}
	
	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	
	public List<Imovel> getImoveis() {
		ImovelRN imovelRN = new ImovelRN();
		if (this.imoveis == null) {
			this.imoveis = imovelRN.listagem();
			
			//AQUI INICIADO NOVO PARA USAR CAMPO DE IMPUT TEXT NA TOOLBAR DA DATAGRID...
			this.contribuinte = new Contribuinte();
		}
		return imoveis;
	}
	
	public void setImoveis(List<Imovel> imoveis) {
		this.imoveis = imoveis;
	}
	
	public Contribuinte getContribuinte() {
		return contribuinte;
	}
	
	public void setContribuinte(Contribuinte contribuinte) {
		this.contribuinte = contribuinte;
	}
	
	//teste nova lista para menu de contexto
	public Imovel getImovelSelecionado() {
		return imovelSelecionado;
	}
	
	//teste nova lista para menu de contexto
	public void setImovelSelecionado(Imovel imovelSelecionado) {
		this.imovelSelecionado = imovelSelecionado;
	}
	
	@PostConstruct
	public void listar() {
		try {
			ImovelRN imovelRN = new ImovelRN();
			this.imoveis = imovelRN.listagem();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar listar um Imovel" + erro);
			erro.printStackTrace();
		}

	}
	
	public void novo() {
		try {
			this.imovel = new Imovel();
			this.contribuinte = new Contribuinte();
			
			ImovelRN imovelRN = new ImovelRN();
			this.imoveis = imovelRN.listagem();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao gerar um novo Imovel" + erro);
			erro.printStackTrace();
		}

	}
	
	public void salvar() {
		try {
			ImovelRN imovelRN = new ImovelRN();
			imovelRN.salvar(this.imovel);
			
			this.imovel = new Imovel();
			this.imoveis = imovelRN.listagem();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar salvar o Imovel" + erro);
			erro.printStackTrace();
		}

	}
	
	public void salvarCapturandoID(ActionEvent evento) {
		try {
			this.imovel = (Imovel) evento.getComponent().getAttributes().get("imovelSelecionado");
			
			ImovelRN imovelRN = new ImovelRN();
			imovelRN.salvar(this.imovel);
			
			this.imovel = new Imovel();
			this.imoveis = imovelRN.listagem();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar salvar o Imovel" + erro);
			erro.printStackTrace();
		}
		
	}
	
	public void excluir(ActionEvent evento) {
		try {
			this.imovel = (Imovel) evento.getComponent().getAttributes().get("imovelSelecionado");
			
			ImovelRN imovelRN = new ImovelRN();
			imovelRN.excluir(this.imovel);
			
			this.imoveis = imovelRN.listagem();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar remover o Imovel");
			erro.printStackTrace();
		}

	}
	
	//UTILIZADO NO TESTE VINDO DO MENU DE CONTEXTO
	public void excluir2() {
		try {
			
			ImovelRN imovelRN = new ImovelRN();
			imovelRN.excluir(imovel);
			
			this.imoveis = imovelRN.listagem();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar remover o Imovel MÉTODO DOIS!");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento) {
			this.imovel = (Imovel) evento.getComponent().getAttributes().get("imovelSelecionado");
	}
	
	//para EDITAR!! IMÓVEL passando o ID do CONTRIBUINTE
	//PASSADO AQUI VIA COMBO...
	public void editarSalvarImovelContribuinte() {
		Contribuinte selectOneMenuContribuinte = this.imovel.getContribuinte();
		
		if (selectOneMenuContribuinte == null) {
			Messages.addGlobalWarn("Ops!... QUAL O CONTRIBUINTE DESSE IMÓVEL?");
				ImovelRN imovelRN = new ImovelRN();
				this.imoveis = imovelRN.listagem();
			
			//STOP ALL HERE!
			return;
		
		} else if (selectOneMenuContribuinte != null) {
			
			try {
				ImovelRN imovelRN = new ImovelRN();
				imovelRN.editar(this.imovel);
				
				this.imovel = new Imovel();
				this.imoveis = imovelRN.listagem();
				
			} catch (RuntimeException erro) {
				Messages.addGlobalError("Erro ao tentar Salvar um IMÓVEL" + erro);
				erro.printStackTrace();
			}
		}
		
	}
	
	//BUSCAS1...
	public void imoveisSemContribuintes () {
		ImovelRN imovelRN = new ImovelRN();
		imoveis = imovelRN.listarImovelZeroContribuinte();
	}
	
	//BUSCAS2...
		public void imoveisComContribuintes () {
			ImovelRN imovelRN = new ImovelRN();
			imoveis = imovelRN.listarImovelAlgumContribuinte();
		}
		
	//BUSCAS3...
		public void imoveisTodos () {
			ImovelRN imovelRN = new ImovelRN();
			imoveis = imovelRN.listagem();
		}
	
	// BUSCAS4...
	public void bucarNomeContratante() {
		try {
			
			ImovelRN imovelRN = new ImovelRN();
			this.imoveis = imovelRN.buscarNomeContratante(contribuinte.getNome());
			
			if (this.imoveis.size() == 0) {
				Messages.addGlobalWarn("O nome: ( " + contribuinte.getNome() + " ) NÃO foi encontrado!");
				
				//PARA LIMPAR O CAMPO NO FORM
				this.contribuinte = new Contribuinte();
				
				//LISTAR NOVAMENTE O DATA GRID
				this.imoveis = imovelRN.listagem();
				
				//PARA A EXECUÇÃO DO MÉTODO
				return;	
			}

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro na BUSCA pelo nome do CONTRIBUINTE" + erro);
			erro.printStackTrace();
		}
	}
		
}
