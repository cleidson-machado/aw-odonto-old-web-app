package br.com.odontoclinic.stuff.checkout.procedimento;

import java.util.List;

import org.hibernate.Session;

import br.com.odontoclinic.model.base.checkout.procedimento.CheckOutProcedimento;
import br.com.odontoclinic.model.base.contrato.Contrato;

public class CheckOutProcedimentoDAOHibernate implements CheckOutProcedimentoDAO {

	private Session session;

	public void setSession(Session session){
		this.session = session;
	}
	
	@Override
	public void salvar(CheckOutProcedimento checkOutProcedimento) {
		this.session.saveOrUpdate(checkOutProcedimento);
		
	}

	@Override
	public void editar(CheckOutProcedimento checkOutProcedimento) {
		this.session.update(checkOutProcedimento);
		
	}

	@Override
	public void excluir(CheckOutProcedimento checkOutProcedimento) {
		this.session.delete(checkOutProcedimento);
		
	}

	@Override
	public CheckOutProcedimento carregar(Long codigo) {
		return (CheckOutProcedimento) this.session.get(CheckOutProcedimento.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CheckOutProcedimento> listarTodos() {
		return this.session.createCriteria(CheckOutProcedimento.class).list();
	}

	//SALVAR UMA LISTA E NÃO SOMENTE UMA TUPLA NO BANCO..????
	@Override
	public void salvarLista(List<CheckOutProcedimento> checkOutProcedimento) {
		this.session.saveOrUpdate(checkOutProcedimento);		
	}
	
	@Override
	public void salvarVenda(Contrato contrato, List<CheckOutProcedimento> checkOutProcedimentos){
		
		this.session.saveOrUpdate(contrato);
		
		for (int posicao = 0; posicao < checkOutProcedimentos.size(); posicao++) {
			
			CheckOutProcedimento checkOutProcedimento = checkOutProcedimentos.get(posicao);
			checkOutProcedimento.setContrato(contrato);
			
			this.session.saveOrUpdate(checkOutProcedimento);
		}
		
	}

}
