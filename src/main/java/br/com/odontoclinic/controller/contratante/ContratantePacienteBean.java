package br.com.odontoclinic.controller.contratante;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.odontoclinic.model.base.contratante.Contratante;
import br.com.odontoclinic.regras.validacao.ValidateCpfCnpj;
import br.com.odontoclinic.stuff.contratante.ContratanteRN;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ContratantePacienteBean implements Serializable {

	private Contratante paciente;
	private List<Contratante> pacientes;

	// Usar no Select One Menu que vai definir a FK da Contante_Pai
	private List<Contratante> apenasContratantes;

	public List<Contratante> getApenasContratantes() {
		ContratanteRN contratanteRN = new ContratanteRN();
		if (apenasContratantes == null) {
			apenasContratantes = contratanteRN.listarApenasContratantes();
		}
		return apenasContratantes;
	}

	public void setApenasContratantes(List<Contratante> apenasContratantes) {
		this.apenasContratantes = apenasContratantes;
	}

	public Contratante getPaciente() {
		return paciente;
	}

	public void setPaciente(Contratante paciente) {
		this.paciente = paciente;
	}

	public List<Contratante> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Contratante> pacientes) {
		this.pacientes = pacientes;
	}

	@PostConstruct
	public void Listar() {

		try {
			ContratanteRN contratanteRN = new ContratanteRN();
			pacientes = contratanteRN.listarApenasPacientes();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar listar Pacientes" + erro);
			erro.printStackTrace();
		}

	}

	public void novo() {
		try {
			paciente = new Contratante();

			ContratanteRN contratanteRN = new ContratanteRN();
			pacientes = contratanteRN.listarApenasPacientes();

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao gerar uma nova Paciente" + erro);
			erro.printStackTrace();
		}
	}

	public void salvar() {
		
		//ENTRA NESTE IF SE FOR UM NOVO REGISTRO NATIVO DE PACIENTE..
		if (this.paciente.getCamada() == null) {
			try {
				ContratanteRN contratanteRN = new ContratanteRN();
				contratanteRN.salvarPa(this.paciente);

				paciente = new Contratante();

				pacientes = contratanteRN.listarApenasPacientes();

				Messages.addGlobalInfo("Paciente SALVA com sucesso!");

			} catch (RuntimeException erro) {
				Messages.addFlashGlobalError("Erro ao tentar SALVAR a Paciente" + erro);
				erro.printStackTrace();
			}
			return;
		
		//AQUI ENTRA SE JÁ EXISTIR NO BD... OU SEJA NA EDIÇÃO...
		} else if (this.paciente.getCamada() != null) {
			salvarEditando();
		}
	}


	public void salvarEditando() {
		String copa = "copa";
		String pa = "pa";
		String cpfNaView = this.paciente.getCpf();
		
		//String registroNativo = "PACIENTE";
		//Contratante contratantePai = this.paciente.getPai();

		// Como se trata de edição o registro que já está no BD então é necessário
		ContratanteRN consulta = new ContratanteRN();
		
		// carregar o mesmo pelo seu código PK e ler a Tupla toda..
		Contratante pacienteBd = consulta.carregar(this.paciente.getCodigo());

		// Entra aqui pra salvar ou editar sempre quem JÁ for uma
		// CONTRATANTE/PACIENTE na camada funcional...
		// OU seja.. contratante já transformada em paciente antes..
		if (pacienteBd.getCamada().equals(copa)) {
			try {
				ContratanteRN contratanteRN = new ContratanteRN();
				contratanteRN.salvarCopa(this.paciente); //SALVAR, SALVAR,SALVAR,SALVAR,SALVAR...

				paciente = new Contratante();
				pacientes = contratanteRN.listarApenasPacientes();

				Messages.addGlobalInfo("Paciente SALVA com sucesso!");
			} catch (RuntimeException erro) {
				Messages.addFlashGlobalError("Erro ao tentar SALVAR a Paciente" + erro);
				erro.printStackTrace();
			}

			// Entra aqui para editar sempre que for uma PACIENTE na camada funcional..
			// Toda PACIENTE pura tem seu tipo nulo.. que depois será alterado para FISICA com a adição do CPF...
		} else if ( (pacienteBd.getCamada().equals(pa) ) && ( cpfNaView == null ) ) {
			try {
				ContratanteRN contratanteRN = new ContratanteRN();
				contratanteRN.salvarPa(this.paciente);  //SALVAR, SALVAR,SALVAR,SALVAR,SALVAR...

				paciente = new Contratante();
				pacientes = contratanteRN.listarApenasPacientes();

				Messages.addGlobalInfo("Paciente SALVA com sucesso!");
			} catch (RuntimeException erro) {

				Messages.addFlashGlobalError("Erro ao tentar SALVAR a Paciente" + erro);
				erro.printStackTrace();
			}
			
			//Entra aqui PRA MUDAR!! de "pa" para "copa" na view da Paciente..
			//Apenas confirma na contratante_pai se é uma Paciente Pura com o relacionamento salvo...
		} else if ( pacienteBd.getCamada().equals(pa) && ( cpfNaView != null ) ) {
			try {
				ContratanteRN contratanteRN = new ContratanteRN();
				contratanteRN.salvarCopaPaciente(this.paciente); //SALVAR, SALVAR,SALVAR,SALVAR,SALVAR...

				paciente = new Contratante();
				pacientes = contratanteRN.listarApenasPacientes();

				Messages.addGlobalInfo("Paciente SALVA com sucesso!");
			} catch (RuntimeException erro) {

				Messages.addFlashGlobalError("Erro ao tentar SALVAR a Paciente" + erro);
				erro.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("static-access")
	public void salvarValidandoCpf(){
		
		String cpfDaView = this.paciente.getCpf();
		
		ContratanteRN consulta = new ContratanteRN();
		int qtdCpfDoBanco = consulta.contagemCpf(this.paciente.getCpf());
		Contratante cpfdoBancoParaEsteRegistro = consulta.carregar(this.paciente.getCodigo());
		
		ValidateCpfCnpj v = new ValidateCpfCnpj();
		boolean cpfValidacoes = v.validarCPF(cpfDaView);
		
		//Entra aqui se for um novo CPF.. pra validar!
		if ( qtdCpfDoBanco == 0 ) {
			if (cpfValidacoes == false) {
				Messages.addFlashGlobalInfo("O CPF  " + cpfDaView + "  é INVÁLIDO!");	
			}else {
				try {
					ContratanteRN contratanteRN = new ContratanteRN();
						salvarEditando();// EDIÇÃO!!! EDIÇÃO!!! EDIÇÃO!!! EDIÇÃO!!! EDIÇÃO!!!	
					paciente = new Contratante();
					pacientes = contratanteRN.listarApenasPacientes();
				} catch (RuntimeException erro) {
					Messages.addFlashGlobalError("Erro ao tentar EDITAR a Contratante" + erro);
					erro.printStackTrace();
				}
				return;
			}
				
		
		//Aqui se já tem no BD e o dessa tupla também está em branco..
		} else if ( (qtdCpfDoBanco == 1) && (cpfdoBancoParaEsteRegistro.getCpf() == null)  ) {
			
				try {
					ContratanteRN contratanteRN = new ContratanteRN();
					paciente = new Contratante();
					pacientes = contratanteRN.listarApenasPacientes();
						Messages.addFlashGlobalWarn("ERRO na edição PACIENTE já CADASTRADA!");
				} catch (RuntimeException erro) {
					Messages.addFlashGlobalError("Erro ao tentar EDITAR a Contratante" + erro);
					erro.printStackTrace();
				}
					//parada aqui!
					return;
		//Aqui se já tem no BD... e é igual ao da View ou dessa tupla...
		} else if ( (qtdCpfDoBanco == 1) && (cpfdoBancoParaEsteRegistro.getCpf().equals( cpfDaView )) ) {
			
			try {
				ContratanteRN contratanteRN = new ContratanteRN();
					salvarEditando();// EDIÇÃO!!! EDIÇÃO!!! EDIÇÃO!!! EDIÇÃO!!! EDIÇÃO!!!
				paciente = new Contratante();
				pacientes = contratanteRN.listarApenasPacientes();
			} catch (RuntimeException erro) {
				Messages.addFlashGlobalError("Erro ao tentar EDITAR a Contratante" + erro);
				erro.printStackTrace();
			}
			
		}	
		
	}

	public void editar(ActionEvent evento) {
		this.paciente = (Contratante) evento.getComponent().getAttributes().get("pacienteSelecionada");
	}

	public void excluir(ActionEvent evento) {
		try {
			this.paciente = (Contratante) evento.getComponent().getAttributes().get("pacienteSelecionada");

			ContratanteRN contratanteRN = new ContratanteRN();
			contratanteRN.excluir(paciente);

			paciente = new Contratante();
			pacientes = contratanteRN.listarApenasPacientes();

			Messages.addGlobalInfo("Paciente removida com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar remover a Paciente");
			erro.printStackTrace();
		}
	}

}
