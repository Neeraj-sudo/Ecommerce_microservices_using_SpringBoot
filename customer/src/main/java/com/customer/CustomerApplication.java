package com.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.customer.entities.Customer;
import com.customer.service.CustomerService;

import brave.sampler.Sampler;

@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class CustomerApplication implements CommandLineRunner{

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
//	@Autowired
//	private CustomerService customerService;
//	
	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
//		Customer customer1=new Customer(name, phoneNo, address, email)
//		Customer customer1=new Customer("ravi", "5454545455", "btm banglore", "ravi@gamil.com");
//		Customer customer2=new Customer("sumit", "5494545455", "noida sec1", "sumit@gamil.com");
//		Customer customer3=new Customer("umesh", "5004545455", "new delhi ", "umesh@gamil.com");
//		
//		customerService.addCustomer(customer1);
//		customerService.addCustomer(customer2);
//		customerService.addCustomer(customer3);
//		System.out.println("-----------------------------");
		
	}

}
