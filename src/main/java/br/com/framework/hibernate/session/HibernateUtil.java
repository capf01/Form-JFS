package br.com.framework.hibernate.session;
/**
 * Responsável por estabelecer a conexao com hibernate
 * @author cesar
 *
 */

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

import javax.faces.bean.ApplicationScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.engine.SessionFactoryImplementor;


import br.com.framework.implementacao.crud.*;

public class HibernateUtil implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	public static String JAVA_COMP_ENV_JDBC_DATA_SOURCE = "java://comp/env/jdbc/datasource";
	
	private static SessionFactory sessionFactory = buildSessionFactory();
	
	/**
	 * Responsável por ler o arquivo de configuração hibernate.cfg.xml
	 * @return o metodo SessionFactory
	 */
	
	private static SessionFactory buildSessionFactory(){
		 
		try {
			
			if (sessionFactory == null) {
				sessionFactory = new Configuration().configure().buildSessionFactory();
			}
			return sessionFactory;// retorna a primeira vez nulo, criando apenas uma vez
		}
		catch (Exception e) {
			
			e.printStackTrace();// exceção no console
			
			throw new ExceptionInInitializerError("Erro ao criar conexão SessionFactory"); // exceção no Virtual Machine
		}
	}
	
	/**
	 * Retorna o SessionFactory corrente
	 * @return SessionFactory
	 */
	
	public static SessionFactory getSessionFactory() {
		
		return sessionFactory;
	}
	
	public static Session getCurrentSession() {
		
		return getSessionFactory().getCurrentSession();
		
	}
	
	/**
	 * Abre uma nova sessao no SessionFactory
	 * return Session
	 */
	
	public static Session openSession () {
		
		if (sessionFactory == null) {
			buildSessionFactory();
		}
		
		return sessionFactory.openSession();
	}
	
	/**
	 * Obtem a conexão do provedor de conexao configurado
	 * @return Connection SQL
	 * @throws SQLException
	 */
	
	public static Connection getConnectionProvider () 
	
	throws SQLException{
		return ((SessionFactoryImplementor) sessionFactory).getConnectionProvider().getConnection();
		
	}
	
	/** 
	 * @return DataSource JNDI Tomcat
	 * @throws NamingException
	 */
	public DataSource getDataSourceJndi ()
			
			throws NamingException{
		
		InitialContext context= new InitialContext();
		
		return (DataSource) 
				context.lookup(VariavelConexaoUtil.JAVA_COMP_ENV_JDBC_DATA_SOURCE);
		
	}
}
