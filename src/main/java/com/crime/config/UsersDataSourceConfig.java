//package com.crime.config;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import jakarta.persistence.EntityManagerFactory;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(entityManagerFactoryRef = "usersEntityManagerFactory", basePackages = {
//		"com.crime.dao.users" }, transactionManagerRef = "usersTransactionManager")
////@RequiredArgsConstructor
//public class UsersDataSourceConfig {
//
//	@Primary
//	@Bean(name = "usersDataSource")
//	@ConfigurationProperties(prefix = "spring.users.datasource")
//	public DataSource dataSource() {
//		return DataSourceBuilder.create().build();
//	}
//
//	@Primary
//	@Bean(name = "usersEntityManagerFactory")
//	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
//			@Qualifier("usersDataSource") DataSource usersDataSource) {
//
//		return builder.dataSource(usersDataSource).packages("com.crime.entity.users").persistenceUnit("users").build();
//	}
//
//	@Primary
//	@Bean(name = "usersTransactionManager")
//	public PlatformTransactionManager transactionManager(
//			@Qualifier("usersEntityManagerFactory") EntityManagerFactory usersEntityManagerFactory) {
//		return new JpaTransactionManager(usersEntityManagerFactory);
//	}
//
//}
