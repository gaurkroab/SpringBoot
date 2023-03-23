package com.gk.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.gk.repository.promos",
													entityManagerFactoryRef="mysqlEMF",
													transactionManagerRef = "mysqlTxMgmr")
public class MYSQLDBConfig {

	@Bean
	@ConfigurationProperties(prefix = "mysql.ds")
	public DataSource createMYSQLDs() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="mysqlEMF")
	public LocalContainerEntityManagerFactoryBean createMySQLEntityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
		// create Map object having hibernate properties 
		Map<String,Object> props=new HashMap();
		props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		props.put("hibernate.hbm2ddl.auto", "update");
		// create and return LocalContainerEntityManagerFactoryBean class obj which makes EntityManagerFActory as the spring bean
		return builder.dataSource(createMYSQLDs())         // datasource
				                   .packages("com.gk.entity.promos")   // model class pkg
				                   .properties(props)								// hibernate properties
				                   .build();
	}
	
	@Bean(name="mysqlTxMgmr")
	public PlatformTransactionManager createMySQLTxMgmr(@Qualifier("mysqlEMF") EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}
}
