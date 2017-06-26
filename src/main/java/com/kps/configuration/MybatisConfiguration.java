package com.kps.configuration;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Import(DatabaseConfiguration.class)
@Configuration
@MapperScan("com.kps.repository")
public class MybatisConfiguration {

	@Autowired
	private DataSource dataSource;
	
	@Bean
	public SqlSessionFactoryBean sessionFactoryBean(){
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		return sessionFactoryBean;
	}
	
	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager(){
		return new DataSourceTransactionManager(dataSource);
	}
	
}
