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
//@EnableJpaRepositories(entityManagerFactoryRef = "crimesEntityManagerFactory", basePackages = {
//		"com.crime.dao.crimes" }, transactionManagerRef = "crimesTransactionManager")
////@RequiredArgsConstructor
//public class CrimesDataSourceConfig {
//
//	@Bean(name = "crimesDataSource")
//	@ConfigurationProperties(prefix = "spring.crimes.datasource")
//	public DataSource dataSource() {
//		return DataSourceBuilder.create().build();
//	}
//
//	@Bean(name = "crimesEntityManagerFactory")
//	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
//			@Qualifier("crimesDataSource") DataSource crimesDataSource) {
//
//		return builder.dataSource(crimesDataSource).packages("com.crime.entity.crimes").persistenceUnit("crimes")
//				.build();
//	}
//
//	@Bean(name = "crimesTransactionManager")
//	public PlatformTransactionManager transactionManager(
//			@Qualifier("crimesEntityManagerFactory") EntityManagerFactory crimesEntityManagerFactory) {
//		return new JpaTransactionManager(crimesEntityManagerFactory);
//	}
//
//}
