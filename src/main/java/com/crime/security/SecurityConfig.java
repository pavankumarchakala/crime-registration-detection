package com.crime.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	private final UserDetailsService userDetailsService;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

		return httpSecurity.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
						.requestMatchers("*/register", "*/login").permitAll().anyRequest().authenticated())
				.formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults()).build();

	}

	// This configuration could also be done at properties file level using
	// spring.security.user.name
	// spring.security.user.password
	@Bean
	public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		UserDetails user = User.builder().username("root").password("{noop}root").roles("ADMIN").build();
		return new InMemoryUserDetailsManager(user);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder(14);
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(bCryptPasswordEncoder());
		return provider;
	}
}
