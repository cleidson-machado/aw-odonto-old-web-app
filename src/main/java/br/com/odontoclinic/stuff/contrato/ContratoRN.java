package br.com.odontoclinic.stuff.contrato;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import br.com.odontoclinic.model.base.contrato.Contrato;
import br.com.odontoclinic.util.DAOFactory;

public class ContratoRN {

	private ContratoDAO contratoDAO;

	public ContratoRN(){
		this.contratoDAO = DAOFactory.criarContratoDAO();
	}

	public ContratoDAO getContratoDAO() {
		return contratoDAO;
	}

	public void setContratoDAO(ContratoDAO contratoDAO) {
		this.contratoDAO = contratoDAO;
	}

	//MÉTODOS PADRÃO...
	public void salvar(Contrato contrato){
		
		Long codigo = contrato.getCodigo();
		
		int vigenciaInformada = contrato.getVigencia();
		Date dataInicialInformada = contrato.getDtaInicio();

			if (codigo == null || codigo == 0) {
				
				if (vigenciaInformada == 0) {
					contrato.setVigencia(90);
					
				}else {
					contrato.setVigencia(vigenciaInformada); 
				}
				
				if (dataInicialInformada == null) {
					contrato.setDtaInicio(new Date());
					
				}else {
					contrato.setDtaInicio(dataInicialInformada);
				}
				
				//Data de Cadastro..
				contrato.setDtaCriacao(new Date());
				
				//Marca como ativo...
				contrato.setStatusContratual("ATIVO");
				
				//this.contratoDAO.salvar(contrato);
				gerarCodigoDaFicha(contrato);
				return;
			}
			
			if (codigo !=null || codigo != 0) {
				
				this.contratoDAO.editar(contrato);
				return;
			}
			
	}
	
	public void gerarCodigoDaFicha(Contrato contrato){
		
		Random n = new Random();
		
		String sufixoContrato = "CTRN";
		Date anoAtual = new Date();
		
		DateFormat formatador = new SimpleDateFormat("YYYY");
		
		int nG1 = 0;
		int nG2 = 0;
		int nG3 = 0;
		int nG4 = 0;
		
		for (int i = 0; i <= 0; ++i) {
			nG1 = n.nextInt(10);
		}
		
		for (int i = 0; i <= 0; ++i) {
			nG2 = n.nextInt(10);
		}
		
		for (int i = 0; i <= 0; ++i) {
			nG3 = n.nextInt(10);
		}
		
		for (int i = 0; i <= 0; ++i) {
			nG4 = n.nextInt(10);
		}
	
		String codGerado = 	sufixoContrato 
							+ "-" 
							+ Integer.toString(nG1) 
							+ Integer.toString(nG2) 
							+ Integer.toString(nG3) 
							+ Integer.toString(nG4)
							+ formatador.format(anoAtual);
		
		contrato.setCodFichaCadastral(codGerado);
		
		this.contratoDAO.salvar(contrato);
	}

	public void editar (Contrato contrato){
		this.contratoDAO.editar(contrato);
	}

	public void excluir (Contrato contrato){
		this.contratoDAO.excluir(contrato);
	}

	public List<Contrato> listagem(){
		return this.contratoDAO.listarTodos();
	}

	public Contrato carregar (Long codigo){
		return this.contratoDAO.carregar(codigo);
	}

}
