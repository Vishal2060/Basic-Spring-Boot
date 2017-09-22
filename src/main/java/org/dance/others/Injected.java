package org.dance.others;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.hibernate.SessionFactory;
import org.jooq.DSLContext;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class Injected {

	@Autowired
	ApplicationContext applicationContext;
	
	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	DSLContext dslContext;
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void any() {
	}
	
}
