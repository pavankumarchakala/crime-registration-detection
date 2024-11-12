package com.crime.config;

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
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "crimesEntityManagerFactory", basePackages = {
		"com.crime.dao.crimes" }, transactionManagerRef = "crimesTransactionManager")
@RequiredArgsConstructor
public class CrimesDataSourceConfig {

	private final Environment environment;

	@Bean(name = "crimesDataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.crimes.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create()
//				.driverClassName(environment.getProperty("spring.crimes.datasource.driver-class-name"))
//				.url(environment.getProperty("spring.crimes.datasource.url"))
//				.username(environment.getProperty("spring.crimes.datasource.username"))
//				.password(environment.getProperty("spring.crimes.datasource.password"))
				.build();
	}

	@Bean(name = "crimesEntityManagerFactory")
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
			@Qualifier("crimesDataSource") DataSource dataSource) {
		Map<String, Object> properties = new HashMap<>();
//		properties.put("", "");

		return builder.dataSource(dataSource).packages("com.crime.entity.crimes").persistenceUnit("crimes").build();
	}

	@Bean(name = "crimesTransactionManager")
	@Primary
	public PlatformTransactionManager transactionManager(
			@Qualifier("crimesEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

}
