package com.prodstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class MySecConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsService;
	
	//Authenication :who can enter into the application
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		/*
		 * auth.inMemoryAuthentication()
		 * .withUser("raj@gmail.com").password("raj123").roles("ADMIN") .and()
		 * .withUser("ekta@gmail.com").password("ekta123").roles("AGENT") .and()
		 * .withUser("gunika@gmail.com").password("gun123").roles("VIEWER");
		 */
	}

//	public BCryptPasswordEncoder getPasswordEncoder(){
//		return new BCryptPasswordEncoder();
//	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	//authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/customer-service/**").hasAnyRole("ADMIN")
		.antMatchers("/product-service/**").hasAnyRole("ADMIN", "AGENT")
		.antMatchers("/order-service/**").hasAnyRole("ADMIN","AGENT","VIEWER")
		.antMatchers("/home/**").permitAll()
		.and().httpBasic().and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
//	
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable()
//		.authorizeRequests()
//		.antMatchers("/customer-service/**").hasAnyRole("ADMIN")
//		.antMatchers("/product-service/**").hasAnyRole("ADMIN", "AGENT")
//		.antMatchers("/order-service/**").hasAnyRole("ADMIN","AGENT","VIEWER")
//		.antMatchers("/home/**").permitAll()
//		//agent
//		.antMatchers("/order-service/order**").hasAnyRole("AGENT") 
//		.antMatchers("/customer-service/customer**").hasAnyRole("AGENT") 
//		.and().httpBasic().and()
//		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//	}

}




