package com.emp.security;

import javax.sql.DataSource;

import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.emp.service.SecurityService;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	@Autowired
	private SecurityService userSecurityService;
	
//	@Bean
//	public JdbcUserDetailsManager userDetailsManager(DataSource dataSource) {
//		JdbcUserDetailsManager userDetails = new JdbcUserDetailsManager(dataSource);
//		return userDetails;
//	}
	
	@Bean
	 void  configure(AuthenticationManagerBuilder auth ) throws Exception {
		auth.userDetailsService(userSecurityService).passwordEncoder(encoder());
	}
	
	@Bean
	BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(auth -> auth
				.requestMatchers("/emps").authenticated() 
				.anyRequest().permitAll()
				).httpBasic(Customizer.withDefaults());
		
		return http.build();
	}

}
