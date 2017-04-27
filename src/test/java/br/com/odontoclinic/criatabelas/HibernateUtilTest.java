package br.com.odontoclinic.criatabelas;

import org.hibernate.Session;

import br.com.odontoclinic.util.HibernateUtil;

public class HibernateUtilTest {

	public static void main(String[] args){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.close();
		HibernateUtil.getSessionFactory().close();
	}
	
}
