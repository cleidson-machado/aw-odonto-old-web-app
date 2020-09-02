package br.com.odontoclinic.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.ReturningWork;

//DATA ODONTOCONTRACT E...
public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
//---- Inicio método específico para converter session do Hibernate em JDBC para uso relatórios do Jasper
	public static Connection getConexao(){
		Session sessao = sessionFactory.openSession();
		
		Connection conexao = sessao.doReturningWork(new ReturningWork<Connection>() {
			@Override
			public Connection execute(Connection conn) throws SQLException {
				return conn;
			}
		});
		
		return conexao;
	}

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			
			StandardServiceRegistryBuilder registradorServico = new StandardServiceRegistryBuilder();
			registradorServico.applySettings(cfg.getProperties());
			StandardServiceRegistry servico = registradorServico.build();

			return cfg.buildSessionFactory(servico);

		} catch (Throwable e) {
			System.out
					.println("Criação inicial do objeto SessionFactory falhou. Erro: "
							+ e);
			throw new ExceptionInInitializerError(e);
		}
	}
	
}
