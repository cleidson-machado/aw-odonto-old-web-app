package br.com.odontoclinic.stuff.contratante;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.odontoclinic.model.base.contratante.Contratante;

public class ContratanteDAOHibernate implements ContratanteDAO {
	
	private Session session;

	public void setSession(Session session){
		this.session = session;
	}

	
	@Override
	public void salvar(Contratante contratante) {
		this.session.saveOrUpdate(contratante);
	}
	

	@Override
	public void editar(Contratante contratante) {
		
		Contratante dataCadastral = this.carregar(contratante.getCodigo());
		contratante.setDtaCadastro(dataCadastral.getDtaCadastro());

			this.session.evict(dataCadastral);

		this.session.update(contratante);
	}

	@Override
	public void excluir(Contratante contratante) {
		this.session.delete(contratante);
		
	}

	@Override
	public Contratante carregar(Long codigo) {
		return (Contratante) this.session.get(Contratante.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contratante> listarTodos() {
		return this.session.createCriteria(Contratante.class).list();
	}
	
	//##################################### MÉTODOS ESPECIALIZADOS EM PESQUISA E AFINS NO BD...
	
	//ESTUDO.. NÃO UTILIZADO NO PROJETO
	@SuppressWarnings("unchecked")
	@Override
	public List<Contratante> buscaCpf(String numerocpf){
		String hql = "SELECT c FROM Contratante c WHERE c.Cpf LIKE :CpfInfo";
		Query consulta = this.session.createQuery(hql).setParameter("CpfInfo", "%" + numerocpf + "%" );
		List<Contratante> resultados = consulta.list();
		return resultados;
	}
	
	//ESTUDO.. NÃO UTILIZADO NO PROJETO.. ESSE É O CARA!!
	@Override
	public Contratante buscaPorCpf(String doCpf){
		String hql = "SELECT c FROM Contratante c WHERE c.Cpf LIKE :pesqdoCpf";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("pesqdoCpf", doCpf);
		return (Contratante) consulta.uniqueResult();
	}
	
	//ESTUDO
	
	public int cpfMaxResultados( String doCpf ){
		String hql = "SELECT c FROM Contratante c WHERE c.Cpf LIKE :pesqdoCpf";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("pesqdoCpf", doCpf);
		return consulta.getMaxResults();
	}
	
	//ESTUDO..
	@Override
	public boolean cpfJaCadastrado(String doCpf){
		String hql = "SELECT c FROM Contratante c WHERE c.Cpf LIKE :pesqdoCpf";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("pesqdoCpf", doCpf);
		//MODIFICADO COM O NOT (!) NO COMEÇO...
		//SE TRUE = ENCONTROU NO BANCO
		//SE FALSE = NÃO ENCOTROU NO BANCO...
		return !consulta.list().isEmpty();
	}
	
	//VERIFICA SE O DADO INFORMADO JÁ ESTÁ PRESENTE NO BANCO E RETORNA A SUA QUANTIDADE EM INTEIRO
	@Override
	public int contaPorCpf(String doCpf){
		String hql = "SELECT c FROM Contratante c WHERE c.Cpf LIKE :pesqdoCpf";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("pesqdoCpf", doCpf);
		return consulta.list().size();
	}
	
	//VERIFICA SE O DADO INFORMADO JÁ ESTÁ PRESENTE NO BANCO E RETORNA A SUA QUANTIDADE EM INTEIRO
	@Override
	public int contaPorCnpj(String doCnpj){
		String hql = "SELECT c FROM Contratante c WHERE c.Cnpj LIKE :pesqdoCnpj";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("pesqdoCnpj", doCnpj);
		return consulta.list().size();
	}
	
	//Criar uma Listagem apenas com Registros que contenham "co" na coluna camada_funcional (Camada)
	@SuppressWarnings("unchecked")
	@Override
	public List<Contratante> listarApenasContratantes(){
		String hql = "SELECT c FROM Contratante c WHERE c.Camada LIKE 'co' OR c.Camada LIKE 'copa'";
		Query consulta = this.session.createQuery(hql);
		return consulta.list();
	}
	
	//Criar uma Listagem apenas com Registros que contenham "pa" na coluna camada_funcional (Camada)
	@SuppressWarnings("unchecked")
	@Override
	public List<Contratante> listarApenasPacientes(){
		String hql = "SELECT c FROM Contratante c WHERE c.Camada LIKE 'pa' OR c.Camada LIKE 'copa'";
		Query consulta = this.session.createQuery(hql);
		return consulta.list();
	}

}
