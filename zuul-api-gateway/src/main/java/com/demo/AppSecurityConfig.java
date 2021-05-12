package com.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("admin@gmail.com").password("admin123").roles("ADMIN")
		.and()
		.withUser("agent@gmail.com").password("agent123").roles("AGENT")
		.and()
		.withUser("viewer@gmail.com").password("viewer123").roles("VIEWER");
		
	}
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/store-service/**").hasAnyRole("ADMIN")
		.antMatchers("/order-service/**").hasAnyRole("ADMIN")
		.antMatchers("/customer-service/**").hasAnyRole("ADMIN", "AGENT")
		//.antMatchers("/product-service/**").hasAnyRole("ADMIN","MGR","EMP")
		.antMatchers("/home/**").permitAll()
		.and().httpBasic().and().sessionManagement().sessionCreationPolicy
		(SessionCreationPolicy.STATELESS);
		
		
	}

}