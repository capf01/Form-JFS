package br.com.framework.implementacao.crud;

import java.io.Serializable;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
(propagation=Propagation.REQUIRED, rollbackFor = Exception.class)//se a transação não existir será criada
public class JdbcTemplateImpl extends JdbcTemplate implements Serializable{
	
	public JdbcTemplateImpl(DataSource dataSource) {
		super(dataSource);
		// conexão com o banco de dados
	}

	private static final long serialVersionUID = 1L;
	

}
