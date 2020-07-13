package com.java.test.mybatis;

import java.io.IOException;
import java.io.InputStream;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Test;

import com.java.test.beans.Employee;
import com.java.test.mappers.EmployeeMapper;

public class TestMybatis {
	
	EmDataSourceFactory emDataSourceFactory = new EmDataSourceFactory();
	
	/**
	 * 第一种配置方式，使用xml配置文件的方式
	 * @throws IOException
	 */
	@Test
	public void test() throws IOException {
		
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		try (SqlSession session = sqlSessionFactory.openSession()) {
			  Employee emp = (Employee) session.selectOne("com.java.test.EmployeeMapper.selectEmp", 1);
			  System.out.println(emp);
			} 
	}
	
	/**
	 * 第二种方式，不适用xml来配置环境和数据库资源的方式
	 */
	@Test
	public void testConnection() {
		
		DataSource dataSource = emDataSourceFactory.getDataSource();
		
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		
		Environment environment = new Environment("development", transactionFactory, dataSource);
		
		Configuration configuration = new Configuration(environment);
		
		configuration.addMapper(EmployeeMapper.class);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		EmployeeMapper emMpper = sqlSession.getMapper(EmployeeMapper.class);
			
		Employee em = emMpper.get(1);
		
		System.out.println(em.toString());
	}
}
