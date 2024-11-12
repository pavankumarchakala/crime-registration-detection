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
@EnableJpaRepositories(entityManagerFactoryRef = "usersEntityManagerFactory", basePackages = {
		"com.crime.dao.users" }, transactionManagerRef = "usersTransactionManager")
@RequiredArgsConstructor
public class UsersDataSourceConfig {

	private final Environment environment;

	@Bean(name = "usersDataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.users.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create()
//				.driverClassName(environment.getProperty("spring.users.datasource.driver-class-name"))
//				.url(environment.getProperty("spring.users.datasource.url"))
//				.username(environment.getProperty("spring.users.datasource.username"))
//				.password(environment.getProperty("spring.users.datasource.password"))
				.build();
	}

	@Bean(name = "usersEntityManagerFactory")
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
			@Qualifier("usersDataSource") DataSource dataSource) {
		Map<String, Object> properties = new HashMap<>();
//		properties.put("", "");

		return builder.dataSource(dataSource).packages("com.crime.entity.users").persistenceUnit("users").build();
	}

	@Bean(name = "usersTransactionManager")
	@Primary
	public PlatformTransactionManager transactionManager(
			@Qualifier("usersEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

}
