package br.com.odontoclinic.model.base.gestudo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OrderBy;

import br.com.odontoclinic.model.base.usuario.Usuario;
import br.com.odontoclinic.model.generic.GenericCadastro;

@SuppressWarnings("serial")
@Entity
public class Painel extends GenericCadastro{
	
	//#################### AUTO RELACIONAMENTO NA TABELA DO BD!! ###################################
	@ManyToOne
	@JoinColumn(name = "painel_pai", nullable = true)
	private Painel pai;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "painel_pai", updatable = false)
	@OrderBy(clause = "original asc")
	private List<Painel> filhos;
	
	//#################### FIM AUTO RELACIONAMENTO NA TABELA DO BD!! ###################################
	
	//####### COMEÇO VEIO DA ANTIGA CLASSE TIKECT #####################################
	
	@Column(name = "txt_recado")
	private String TxtRecado;
	
	@Column(name = "status_finalizado")
	private String StatusFinalizado;
	
	@Column(name = "dta_finalizado")
	@Temporal(TemporalType.TIMESTAMP)
	private Date DtaFinalizado;
	
	//####### FIM VEIO DA ANTIGA CLASSE TIKECT #######################################
	
	@Column(name = "original")
	private Boolean Original;

	@Column(name = "qtd_fila_geral")
	private int	QtdFilaGeral;
	
	@Column(name = "tipo_atendimento")
	private String TipoAtendimento;
	
	@Column(name = "nivel_atendimento")
	private int NivelAtendimento;
	
	@Column(name = "qtd_fila_espera")
	private int QtdFilaEspera;
	
	@Column(name = "status_flag")
	private String StatusFlag;
	
	@Column(name = "item_observacao_alerta")
	private Boolean ItemObservacaoAlerta;
	
	@Column(name = "action_on_demand")
	private String ActionOnDemand;
	
	@Column(name = "contato_nome")
	private String ContatoNome;
	
	@Column(name = "resumo_chamado_atual")
	private String ResumoChamadoAtual;
	
	@Column(name = "equipe_nome")
	private String EquipeNome;
	
	@Column(name = "status_do_item_de_painel")
	private Boolean StatusDoItemDePainel;
	
	//STATUS PADRÃO exemplos: NOVO, RECAL
	@Column(name = "ticket_status")
	private String TicketStatus;
	
	@Column(name = "item_ativo_no_painel")
	private Boolean ItemAtivoNoPainel;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dta_inicio")
	private Date DtaInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "hora_inicio")
	private Date HoraInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dta_fim")
	private Date DtaFim;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "hora_fim")
	private Date HoraFim;
	
	@Column(name = "contato_observacoes")
	private String ContatoObsesvacoes;

	//CLASSE RE-APROVEITADA DO PROJETO ODONTO!
	// FK --- AQUI!!
	// MUITOS ITENS DE PAINEL PARA UMA USUÁRIO....
	@ManyToOne
	@JoinColumn(nullable = true)
	private Usuario usuario;//##############################
	
	//FK --- AQUI!!
	//MUITOS ITENS DE PAINEL PARA UMA CLIENTE....
	@ManyToOne
	@JoinColumn(nullable = true)//ALTERADO para true PARA SALAR ID DO CLIENTE ESCOLHIDO NO TICKET PARA ESSE ITEM DE PAINEL
	private Cliente cliente;//##############################
	
	//FK --- AQUI!!
	//MUITOS ITENS DE PAINEL PARA UMA ASSUNTO....
	@ManyToOne
	@JoinColumn(nullable = true)
	private Assunto assunto;//##############################

	//CHAMADA DE RETORNO DO RELACIONAMENTO PARA CLASSE/TABELA Históricos
	//UMA ENTRADA DE PAINEL PODE TER OU ACESSAR UMA LISTA DE HISTÓRICOS.. para ELA mesma...
	@OneToMany(mappedBy="painel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Historico> historicos;

	//GETERS AND SETERS
	public Painel getPai() {
		return pai;
	}

	public void setPai(Painel pai) {
		this.pai = pai;
	}

	public List<Painel> getFilhos() {
		return filhos;
	}

	public void setFilhos(List<Painel> filhos) {
		this.filhos = filhos;
	}

	public String getTxtRecado() {
		return TxtRecado;
	}

	public void setTxtRecado(String txtRecado) {
		TxtRecado = txtRecado;
	}

	public String getStatusFinalizado() {
		return StatusFinalizado;
	}

	public void setStatusFinalizado(String statusFinalizado) {
		StatusFinalizado = statusFinalizado;
	}

	public Date getDtaFinalizado() {
		return DtaFinalizado;
	}

	public void setDtaFinalizado(Date dtaFinalizado) {
		DtaFinalizado = dtaFinalizado;
	}

	public Boolean getOriginal() {
		return Original;
	}

	public void setOriginal(Boolean original) {
		Original = original;
	}

	public int getQtdFilaGeral() {
		return QtdFilaGeral;
	}

	public void setQtdFilaGeral(int qtdFilaGeral) {
		QtdFilaGeral = qtdFilaGeral;
	}

	public String getTipoAtendimento() {
		return TipoAtendimento;
	}

	public void setTipoAtendimento(String tipoAtendimento) {
		TipoAtendimento = tipoAtendimento;
	}

	public int getNivelAtendimento() {
		return NivelAtendimento;
	}

	public void setNivelAtendimento(int nivelAtendimento) {
		NivelAtendimento = nivelAtendimento;
	}

	public int getQtdFilaEspera() {
		return QtdFilaEspera;
	}

	public void setQtdFilaEspera(int qtdFilaEspera) {
		QtdFilaEspera = qtdFilaEspera;
	}

	public String getStatusFlag() {
		return StatusFlag;
	}

	public void setStatusFlag(String statusFlag) {
		StatusFlag = statusFlag;
	}

	public Boolean getItemObservacaoAlerta() {
		return ItemObservacaoAlerta;
	}

	public void setItemObservacaoAlerta(Boolean itemObservacaoAlerta) {
		ItemObservacaoAlerta = itemObservacaoAlerta;
	}

	public String getActionOnDemand() {
		return ActionOnDemand;
	}

	public void setActionOnDemand(String actionOnDemand) {
		ActionOnDemand = actionOnDemand;
	}

	public String getContatoNome() {
		return ContatoNome;
	}

	public void setContatoNome(String contatoNome) {
		ContatoNome = contatoNome;
	}

	public String getResumoChamadoAtual() {
		return ResumoChamadoAtual;
	}

	public void setResumoChamadoAtual(String resumoChamadoAtual) {
		ResumoChamadoAtual = resumoChamadoAtual;
	}

	public String getEquipeNome() {
		return EquipeNome;
	}

	public void setEquipeNome(String equipeNome) {
		EquipeNome = equipeNome;
	}

	public Boolean getStatusDoItemDePainel() {
		return StatusDoItemDePainel;
	}

	public void setStatusDoItemDePainel(Boolean statusDoItemDePainel) {
		StatusDoItemDePainel = statusDoItemDePainel;
	}

	public String getTicketStatus() {
		return TicketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		TicketStatus = ticketStatus;
	}

	public Boolean getItemAtivoNoPainel() {
		return ItemAtivoNoPainel;
	}

	public void setItemAtivoNoPainel(Boolean itemAtivoNoPainel) {
		ItemAtivoNoPainel = itemAtivoNoPainel;
	}

	public Date getDtaInicio() {
		return DtaInicio;
	}

	public void setDtaInicio(Date dtaInicio) {
		DtaInicio = dtaInicio;
	}

	public Date getHoraInicio() {
		return HoraInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		HoraInicio = horaInicio;
	}

	public Date getDtaFim() {
		return DtaFim;
	}

	public void setDtaFim(Date dtaFim) {
		DtaFim = dtaFim;
	}

	public Date getHoraFim() {
		return HoraFim;
	}

	public void setHoraFim(Date horaFim) {
		HoraFim = horaFim;
	}

	public String getContatoObsesvacoes() {
		return ContatoObsesvacoes;
	}

	public void setContatoObsesvacoes(String contatoObsesvacoes) {
		ContatoObsesvacoes = contatoObsesvacoes;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Assunto getAssunto() {
		return assunto;
	}

	public void setAssunto(Assunto assunto) {
		this.assunto = assunto;
	}

	public List<Historico> getHistoricos() {
		return historicos;
	}

	public void setHistoricos(List<Historico> historicos) {
		this.historicos = historicos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((ActionOnDemand == null) ? 0 : ActionOnDemand.hashCode());
		result = prime * result + ((ContatoNome == null) ? 0 : ContatoNome.hashCode());
		result = prime * result + ((ContatoObsesvacoes == null) ? 0 : ContatoObsesvacoes.hashCode());
		result = prime * result + ((DtaFim == null) ? 0 : DtaFim.hashCode());
		result = prime * result + ((DtaFinalizado == null) ? 0 : DtaFinalizado.hashCode());
		result = prime * result + ((DtaInicio == null) ? 0 : DtaInicio.hashCode());
		result = prime * result + ((EquipeNome == null) ? 0 : EquipeNome.hashCode());
		result = prime * result + ((HoraFim == null) ? 0 : HoraFim.hashCode());
		result = prime * result + ((HoraInicio == null) ? 0 : HoraInicio.hashCode());
		result = prime * result + ((ItemAtivoNoPainel == null) ? 0 : ItemAtivoNoPainel.hashCode());
		result = prime * result + ((ItemObservacaoAlerta == null) ? 0 : ItemObservacaoAlerta.hashCode());
		result = prime * result + NivelAtendimento;
		result = prime * result + ((Original == null) ? 0 : Original.hashCode());
		result = prime * result + QtdFilaEspera;
		result = prime * result + QtdFilaGeral;
		result = prime * result + ((ResumoChamadoAtual == null) ? 0 : ResumoChamadoAtual.hashCode());
		result = prime * result + ((StatusDoItemDePainel == null) ? 0 : StatusDoItemDePainel.hashCode());
		result = prime * result + ((StatusFinalizado == null) ? 0 : StatusFinalizado.hashCode());
		result = prime * result + ((StatusFlag == null) ? 0 : StatusFlag.hashCode());
		result = prime * result + ((TicketStatus == null) ? 0 : TicketStatus.hashCode());
		result = prime * result + ((TipoAtendimento == null) ? 0 : TipoAtendimento.hashCode());
		result = prime * result + ((TxtRecado == null) ? 0 : TxtRecado.hashCode());
		result = prime * result + ((assunto == null) ? 0 : assunto.hashCode());
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((filhos == null) ? 0 : filhos.hashCode());
		result = prime * result + ((historicos == null) ? 0 : historicos.hashCode());
		result = prime * result + ((pai == null) ? 0 : pai.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Painel other = (Painel) obj;
		if (ActionOnDemand == null) {
			if (other.ActionOnDemand != null)
				return false;
		} else if (!ActionOnDemand.equals(other.ActionOnDemand))
			return false;
		if (ContatoNome == null) {
			if (other.ContatoNome != null)
				return false;
		} else if (!ContatoNome.equals(other.ContatoNome))
			return false;
		if (ContatoObsesvacoes == null) {
			if (other.ContatoObsesvacoes != null)
				return false;
		} else if (!ContatoObsesvacoes.equals(other.ContatoObsesvacoes))
			return false;
		if (DtaFim == null) {
			if (other.DtaFim != null)
				return false;
		} else if (!DtaFim.equals(other.DtaFim))
			return false;
		if (DtaFinalizado == null) {
			if (other.DtaFinalizado != null)
				return false;
		} else if (!DtaFinalizado.equals(other.DtaFinalizado))
			return false;
		if (DtaInicio == null) {
			if (other.DtaInicio != null)
				return false;
		} else if (!DtaInicio.equals(other.DtaInicio))
			return false;
		if (EquipeNome == null) {
			if (other.EquipeNome != null)
				return false;
		} else if (!EquipeNome.equals(other.EquipeNome))
			return false;
		if (HoraFim == null) {
			if (other.HoraFim != null)
				return false;
		} else if (!HoraFim.equals(other.HoraFim))
			return false;
		if (HoraInicio == null) {
			if (other.HoraInicio != null)
				return false;
		} else if (!HoraInicio.equals(other.HoraInicio))
			return false;
		if (ItemAtivoNoPainel == null) {
			if (other.ItemAtivoNoPainel != null)
				return false;
		} else if (!ItemAtivoNoPainel.equals(other.ItemAtivoNoPainel))
			return false;
		if (ItemObservacaoAlerta == null) {
			if (other.ItemObservacaoAlerta != null)
				return false;
		} else if (!ItemObservacaoAlerta.equals(other.ItemObservacaoAlerta))
			return false;
		if (NivelAtendimento != other.NivelAtendimento)
			return false;
		if (Original == null) {
			if (other.Original != null)
				return false;
		} else if (!Original.equals(other.Original))
			return false;
		if (QtdFilaEspera != other.QtdFilaEspera)
			return false;
		if (QtdFilaGeral != other.QtdFilaGeral)
			return false;
		if (ResumoChamadoAtual == null) {
			if (other.ResumoChamadoAtual != null)
				return false;
		} else if (!ResumoChamadoAtual.equals(other.ResumoChamadoAtual))
			return false;
		if (StatusDoItemDePainel == null) {
			if (other.StatusDoItemDePainel != null)
				return false;
		} else if (!StatusDoItemDePainel.equals(other.StatusDoItemDePainel))
			return false;
		if (StatusFinalizado == null) {
			if (other.StatusFinalizado != null)
				return false;
		} else if (!StatusFinalizado.equals(other.StatusFinalizado))
			return false;
		if (StatusFlag == null) {
			if (other.StatusFlag != null)
				return false;
		} else if (!StatusFlag.equals(other.StatusFlag))
			return false;
		if (TicketStatus == null) {
			if (other.TicketStatus != null)
				return false;
		} else if (!TicketStatus.equals(other.TicketStatus))
			return false;
		if (TipoAtendimento == null) {
			if (other.TipoAtendimento != null)
				return false;
		} else if (!TipoAtendimento.equals(other.TipoAtendimento))
			return false;
		if (TxtRecado == null) {
			if (other.TxtRecado != null)
				return false;
		} else if (!TxtRecado.equals(other.TxtRecado))
			return false;
		if (assunto == null) {
			if (other.assunto != null)
				return false;
		} else if (!assunto.equals(other.assunto))
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (filhos == null) {
			if (other.filhos != null)
				return false;
		} else if (!filhos.equals(other.filhos))
			return false;
		if (historicos == null) {
			if (other.historicos != null)
				return false;
		} else if (!historicos.equals(other.historicos))
			return false;
		if (pai == null) {
			if (other.pai != null)
				return false;
		} else if (!pai.equals(other.pai))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
}