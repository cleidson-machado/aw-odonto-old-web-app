package br.com.odontoclinic.controller.contratante;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.odontoclinic.model.base.contratante.Contratante;
import br.com.odontoclinic.model.base.referencia.Referencia;
import br.com.odontoclinic.regras.validacao.ValidateCpfCnpj;
import br.com.odontoclinic.stuff.contratante.ContratanteENum;
import br.com.odontoclinic.stuff.contratante.ContratanteRN;
import br.com.odontoclinic.stuff.referencia.ReferenciaRN;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped //Manter View pois estou trabalhando com ActionEvent?
			//Mesmo alterando no DAO com IF e Update se Mudar aqui para @RequestScoped ira criar novo e não alterar!!
public class ContratanteBean implements Serializable {
	
	private Contratante contratante;
	private List<Contratante> contratantes;
	private List<Referencia> referencias;
	
	//ESTE ENUM NÃO ESTÁ MAIS SENDO USADO POIS O TIPO É DEFINIDO COM A INCLUSÃO OU NÃO DO CNPJ...
	private ContratanteENum tipoFisicaJuridica;
	
	public ContratanteENum[] getLabel(){
		return ContratanteENum.values();
	}
	
	//########################### GET E SET REFERENCIAS VERIFICAR!!!
	
	//CRIAR MÉTODO PARA LISTAR TODAS AS REFERENCIAS ENCONTRADAS PARA CONTRATANTE COM  CHAVE DE REGISTRO TAL..
	public List<Referencia> getReferencias() {
		ReferenciaRN referenciaRN = new ReferenciaRN();
		if (referencias == null) {
			referencias = referenciaRN.listagem();
		}
		return referencias;
	}
	
	public void setReferencias(List<Referencia> referencias) {
		this.referencias = referencias;
	}
	
	//###########################
	
	public ContratanteENum getTipoFisicaJuridica() {
		return tipoFisicaJuridica;
	}
	public void setTipoFisicaJuridica(ContratanteENum tipoFisicaJuridica) {
		this.tipoFisicaJuridica = tipoFisicaJuridica;
	}
	
	//Usado assim para popular os campo do diálogo
	public Contratante getContratante() {
		if (this.contratante == null) {
			this.contratante = new Contratante();
		}
		return contratante;
	}
	public void setContratante(Contratante contratante) {
		this.contratante = contratante;
	}
	
	public List<Contratante> getContratantes() {
		return contratantes;
	}
	public void setContratantes(List<Contratante> contratantes) {
		this.contratantes = contratantes;
	}
	
	@PostConstruct
	public void Listar(){
		try {
				ContratanteRN contratanteRN = new ContratanteRN();
				contratantes = contratanteRN.listarApenasContratantes();
				
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar listar Contratantes" + erro);
			erro.printStackTrace();
		}
	}
	
	//Usado como Gatilho no botão Novo.. Criar novo.. nas views
	public void novo(){
		try {
				contratante = new Contratante();
			
				ContratanteRN contratanteRN = new ContratanteRN();
				contratantes = contratanteRN.listarApenasContratantes();
				
				//VERIFICAR DEPOIS A NECESSIDADE DE LISTAR NOVAMENTE A LIST DAS REFERENCIAS AQUI!
				//ReferenciaRN referenciaRN = new ReferenciaRN();
				//referencias = referenciaRN.listagem();
				
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao gerar uma nova Contratante" + erro);
			erro.printStackTrace();
		}
	}

	//#################################### MÉTODOS ESPECIALIZADOS....
	
	//MÉTODO USADO APENAS NA 1ª VIEW QUE SALVA E EDITA COM O CPF
	public void salvar(){
		if (this.contratante.getCodigo() == null) {
			salvarCriando();
			
		} else if ( (this.contratante.getCodigo() != null) && (this.contratante.getCpf() != null ) ) {
			salvarEditando();//VALE APENAS PARA A VIEW QUE SALVA E EDITA CPF E OUTROS BÁSICOS
		}
	}

	@SuppressWarnings("static-access")
	public void salvarCriando (){
		String cpfDaView = this.contratante.getCpf();
		ContratanteRN consulta = new ContratanteRN();
		int qtdCpfDoBanco = consulta.contagemCpf(this.contratante.getCpf());
		ValidateCpfCnpj v = new ValidateCpfCnpj();
		boolean cpfValidacoes = v.validarCPF(cpfDaView);
		if (qtdCpfDoBanco == 0) {
			if (cpfValidacoes == false) {
				Messages.addFlashGlobalInfo("O CPF  " + cpfDaView + "  é INVÁLIDO!");				
			}else{				
					try {
						ContratanteRN contratanteRN = new ContratanteRN();
						contratanteRN.salvar(this.contratante);
								contratante = new Contratante();
								contratantes = contratanteRN.listarApenasContratantes();
					
					} catch (RuntimeException erro) {
						Messages.addFlashGlobalError("Erro ao tentar SALVAR a Contratante" + erro);
						erro.printStackTrace();
					}
			}			
		}else{
			Messages.addGlobalError("ERRO na criação CONTRATANTE já CADASTRADA!");
						ContratanteRN contratanteRN = new ContratanteRN();
								contratante = new Contratante();
								contratantes = contratanteRN.listarApenasContratantes();
		}
	}

	public void salvarEditando(){
		String cpfDaView = this.contratante.getCpf();
		String nome = this.contratante.getNome();
		String sobrenome = this.contratante.getSobreNome();
		ContratanteRN consulta = new ContratanteRN();
		int qtdCpfDoBanco = consulta.contagemCpf(this.contratante.getCpf());
		Contratante cpfdoBanco = consulta.carregar(this.contratante.getCodigo());
		//SE FOR ZERO NÃO EXISTE PARA NENHUM OUTRO REGISTRO...
		if (qtdCpfDoBanco == 0) {
			try {
				ContratanteRN contratanteRN = new ContratanteRN();
				contratanteRN.editar(this.contratante);// EDIÇÃO!!! EDIÇÃO!!! EDIÇÃO!!! EDIÇÃO!!! EDIÇÃO!!!
						contratante = new Contratante();
						contratantes = contratanteRN.listarApenasContratantes();
						Messages.addFlashGlobalInfo("Contratante  " + nome + " " 
																	+ sobrenome + " Editada com Sucesso!");
			} catch (RuntimeException erro) {
				Messages.addFlashGlobalError("Erro ao tentar EDITAR a Contratante" + erro);
				erro.printStackTrace();
			}
		//SE CAIR AQUI JÁ EXISTE... MAS ESTÁ CADASTRADA PARA O MESMO REGISTRO EDITADO...
		} else if ( (qtdCpfDoBanco == 1) && (cpfdoBanco.getCpf().equals( cpfDaView )) ) {
			try {
				ContratanteRN contratanteRN = new ContratanteRN();
				contratanteRN.editar(this.contratante);// EDIÇÃO!!! EDIÇÃO!!! EDIÇÃO!!! EDIÇÃO!!! EDIÇÃO!!!
						contratante = new Contratante();
						contratantes = contratanteRN.listarApenasContratantes();
						Messages.addFlashGlobalInfo("Contratante  " + nome + " " 
																	+ sobrenome + " Editada com Sucesso!");
			} catch (RuntimeException erro) {
				Messages.addFlashGlobalError("Erro ao tentar EDITAR a Contratante" + erro);
				erro.printStackTrace();
			}
		//SE CAIR AQUI JÁ EXISTE... MAS ESTÁ CADASTRADA PARA OUTRO REGISTRO SALVO ANTERIORMENTE..
		} else if ((qtdCpfDoBanco == 1) && (!cpfdoBanco.getCpf().equals( cpfDaView ))) {
			Messages.addGlobalError("ERRO na edição CONTRATANTE já CADASTRADA!");
			ContratanteRN contratanteRN = new ContratanteRN();
					contratante = new Contratante();
					contratantes = contratanteRN.listarApenasContratantes();
		}
	}

	// USADA NA OUTRA VIEW QUE SALVA EDITANDO E ACRESCENTA O CNPJ...
	@SuppressWarnings("static-access")
	public void salvarCnpj() {
		String nome = this.contratante.getNome();
		String sobrenome = this.contratante.getSobreNome();

		String cnpjDaView = this.contratante.getCnpj();
		ValidateCpfCnpj v = new ValidateCpfCnpj();
		boolean cnpjValidacoes = v.validarCNPJ(cnpjDaView);

		ContratanteRN consulta = new ContratanteRN();
		Contratante cnpjdoBanco = consulta.carregar(this.contratante.getCodigo());
		int qtdCnpjDoBanco = consulta.contagemCnpj(this.contratante.getCnpj());

			if (cnpjdoBanco.getCnpj() == null && qtdCnpjDoBanco == 1) {
				Messages.addGlobalError("ERRO na edição CNPJ já CADASTRADO para outro registro!");
				ContratanteRN contratanteRN = new ContratanteRN();
				contratante = new Contratante();
				contratantes = contratanteRN.listarApenasContratantes();
				
			} //PRIMEIRO VERIFICA SE É INVÁLIDO...
			else if ( cnpjValidacoes == false ) {
				Messages.addFlashGlobalInfo("O CNPJ  " + cnpjDaView + "  é INVÁLIDO!");
				ContratanteRN contratanteRN = new ContratanteRN();
				contratante = new Contratante();
				contratantes = contratanteRN.listarApenasContratantes();

				//DEPOIS EXCLUINDO O CASO DE ATUALIZAR ELE MESMO...
			} else if ((qtdCnpjDoBanco == 1) && (cnpjdoBanco.getCnpj().equals(cnpjDaView))) {
				try {
					ContratanteRN contratanteRN = new ContratanteRN();
					contratanteRN.editar(this.contratante);// EDIÇÃO!!!
					contratante = new Contratante();
					contratantes = contratanteRN.listarApenasContratantes();
					Messages.addFlashGlobalInfo("CNPJ para " + nome + " " + sobrenome + " ACRESCENTADO com Sucesso!");
				} catch (RuntimeException erro) {
					Messages.addFlashGlobalError("Erro ao tentar EDITAR CNPJ da Contratante" + erro);
					erro.printStackTrace();
				}

				// CNPJ NOVO E VALIDADO...
			} else if ((qtdCnpjDoBanco == 0) && (cnpjValidacoes == true)) {
				try {
					ContratanteRN contratanteRN = new ContratanteRN();
					contratanteRN.editar(this.contratante);// EDIÇÃO!!!
					contratante = new Contratante();
					contratantes = contratanteRN.listarApenasContratantes();
					Messages.addFlashGlobalInfo("CNPJ para " + nome + " " + sobrenome + " ACRESCENTADO com Sucesso!");
				} catch (RuntimeException erro) {
					Messages.addFlashGlobalError("Erro ao tentar EDITAR CNPJ da Contratante" + erro);
					erro.printStackTrace();
				}

				//SE O CNPJ JÁ TIVER SIDO CADASTRADO PARA OUTRO REGISTRO DIFERENTE DO EDITADO....
			} else if ( (qtdCnpjDoBanco == 1) && ( !cnpjdoBanco.getCnpj().equals(cnpjDaView) )  ) {
				Messages.addGlobalError("ERRO na edição CNPJ já CADASTRADO para outro registro!");
				ContratanteRN contratanteRN = new ContratanteRN();
				contratante = new Contratante();
				contratantes = contratanteRN.listarApenasContratantes();
			
			}
	}
	
	public void excluirCnpj(ActionEvent evento){
		String cnpjQueSeraExcluido = this.contratante.getCnpj();
		try {
			this.contratante = (Contratante) evento.getComponent().getAttributes().get("contratanteSelecionada");
			
			ContratanteRN contratanteRN = new ContratanteRN();
			contratanteRN.excluirCnpj(contratante); 
			contratante = new Contratante();
			contratantes = contratanteRN.listarApenasContratantes();
			
			Messages.addFlashGlobalInfo("CNPJ ( " + cnpjQueSeraExcluido + " ) removido!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar remover CNPJ da Contratante");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento){
		
		try {
			this.contratante = (Contratante) evento.getComponent().getAttributes().get("contratanteSelecionada");
			
			ContratanteRN contratanteRN = new ContratanteRN();
			contratanteRN.excluir(contratante); 
			
			contratante = new Contratante();
			contratantes = contratanteRN.listarApenasContratantes();
			
			Messages.addGlobalInfo("Contratante removida com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar remover a Contratante");
			erro.printStackTrace();
		}
		
	}
	
	public void editar(ActionEvent evento){
		this.contratante = (Contratante) evento.getComponent().getAttributes().get("contratanteSelecionada");
	}
	
	//USADO PARA FILTRAR O DATATABLE DAS REFERENCIAS LISTADAS APARTIR DO DATATABLE DA CONTRATANTE..
	public void pesquisar(ActionEvent evento){
		this.contratante = (Contratante) evento.getComponent().getAttributes().get("contratanteSelecionada");
		
		ReferenciaRN consultaRef = new ReferenciaRN();
		referencias = consultaRef.listaRefContratante(contratante.getCodigo());
	}
	
	//ESTUDO MÉTODO AQUI QUE RETORNE A QTD DE REFERENCIAS PARA A VIEW DA CONTRATANTE..
	public int qtdReferencias(){
		ReferenciaRN consultaRef = new ReferenciaRN();
		int qtdRef = consultaRef.listaRefContratante(this.contratante.getCodigo()).size();
		
		return qtdRef;
	}
	
	public void salvarEditandoCamadaFuncional(){
		this.contratante.setCamada("copa");
		salvarEditando();
	}
	
}
