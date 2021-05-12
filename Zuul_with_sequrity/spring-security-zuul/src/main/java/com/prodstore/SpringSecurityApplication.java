package com.prodstore;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import com.prodstore.entities.AppUser;
import com.prodstore.service.AppUserService;
@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class SpringSecurityApplication implements CommandLineRunner{

	@Autowired
	private AppUserService appUserService;
	
	public static void main(String[] args) throws ParseException {
		SpringApplication.run(SpringSecurityApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
//		AppUser appUser1=new AppUser("admin", "admin123", "admin@gmail.com", "4645454545", "delhi", "ROLE_ADMIN");
//		AppUser appUser2=new AppUser("agent","agent123", "agent@gmail.com", "4600454545", "delhi", "ROLE_AGENT");
//		AppUser appUser3=new AppUser("viewer", "viewer123", "viewer@gmail.com", "4115454545", "delhi", "ROLE_VIEWER");
//		
//		appUserService.addAppUser(appUser1);
//		appUserService.addAppUser(appUser2);
//		appUserService.addAppUser(appUser3);
//		
		System.out.println("3 users are added....");
	}

}





