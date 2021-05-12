package com.store;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



import com.store.entities.Store;

import com.store.service.StoreService;
@EnableEurekaClient
@SpringBootApplication
public class StoreApplication implements CommandLineRunner{


	@Autowired
	private StoreService storeService;
	
	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		
//		Store store1 = new Store(101, "store1",  "123456", "delhi", "delhi");
//		Store store2 = new Store(102, "store2",  "123356", "bangalore", "karnataka");
//		Store store3 = new Store(103, "store3",  "123556", "hyderabad", "telangana");
//		
//		
//		storeService.addStore(store1);
//		storeService.addStore(store2);
//		storeService.addStore(store3);

		System.out.println("-----------------------------");
		
	}

}
