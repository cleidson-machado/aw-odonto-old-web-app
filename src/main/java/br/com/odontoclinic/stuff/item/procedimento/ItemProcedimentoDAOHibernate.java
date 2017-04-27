package br.com.odontoclinic.stuff.item.procedimento;

import java.util.List;

import org.hibernate.Session;

import br.com.odontoclinic.model.base.item.procedimento.ItemProcedimento;

public class ItemProcedimentoDAOHibernate implements ItemProcedimentoDAO {

	private Session session;

	public void setSession(Session session){
		this.session = session;
	}
	
	@Override
	public void salvar(ItemProcedimento itemProcedimento) {
		this.session.saveOrUpdate(itemProcedimento);
		
	}

	@Override
	public void editar(ItemProcedimento itemProcedimento) {
		this.session.update(itemProcedimento);
		
	}

	@Override
	public void excluir(ItemProcedimento itemProcedimento) {
		this.session.delete(itemProcedimento);
		
	}

	@Override
	public ItemProcedimento carregar(Long codigo) {
		return (ItemProcedimento) this.session.get(ItemProcedimento.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemProcedimento> listarTodos() {
		return this.session.createCriteria(ItemProcedimento.class).list();
	}

}
