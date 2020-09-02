package br.com.odontoclinic.crud;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.com.odontoclinic.model.base.prova.Produto;
import br.com.odontoclinic.stuff.prova.produto.ProdutoRN;
import br.com.odontoclinic.util.HibernateUtil;


public class ProdutoCrudDAOTest implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private static Session sessao;
	private static Transaction transacao;
	
	@BeforeClass
	public static void abreConexao() {
		sessao = HibernateUtil.getSessionFactory().getCurrentSession();
		transacao = sessao.beginTransaction();
	}

	//###################### START
	
	//@Test
	@Ignore
	public void salvar(){
		//IMPLEMENT...
	
	//BigDecimal doPreco;
	
	//doPreco = 0;
		
	Produto produto = new Produto();
	
	//produto.setDescricao("ESCOVA DE DESTES ABO PLUS");
	//produto.setCodigoFabrica("ZYZ1234U");
	//produto.setPrecoBase(!!!!);
	//produto.setDataCadProduto(new Date());
	//produto.setQtdEmEstoque(1);
	//produto.setCategoria("HIGIENE PESSOAL");
	
	
	ProdutoRN produtoRN = new ProdutoRN();
	produtoRN.salvar();
	
	System.out.println("Um Produto de teste foi Salvo com Sucesso!");
		
	}
	
	
	//###################### END
	
	@AfterClass
	public static void fechaConexao() {

		try {

			transacao.commit();

		} catch (Throwable e) {
			System.out.println("deu problema no commit : " + e.getMessage());
		} finally {
			try {
				if (sessao.isOpen()) {
					sessao.close();
				}
			} catch (Exception e2) {
				System.out.println("Deu erro no fechamanto da sessão" + e2.getMessage());
			}
		}
	}
	
}
