package com.customer.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.customer.entities.Customer;
import com.customer.service.CustomerService;


@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger=LoggerFactory.getLogger(CustomerController.class);
	@GetMapping("customerservice")
	public String getCustomer() {
		logger.info("inside customercontroller product-service");
		//String value =restTemplate.getForObject("http://localhost:8082/product-service", String.class);
		//logger.info("value return from product-service"+value);
		return "hello from customer-service";
	}
	
	
	//get all
	@GetMapping("customer")
	public ResponseEntity<List<Customer>>  getAll(){
		List<Customer> customers=customerService.getAll();
		
		return ResponseEntity.ok(customers);
	}
	
	//get by id
	@GetMapping("customer/{customerId}")
	public ResponseEntity<Customer>  getAnCustomer(@PathVariable(name = "customerId")int customerId){
		Customer customer=customerService.getById(customerId);
		return ResponseEntity.ok(customer);
	}
	
	//delete
	@DeleteMapping("customer/{customerId}")
	public ResponseEntity<Void>  deleteAnCustomer(@PathVariable(name = "customerId")int customerId){
		Customer customer=customerService.deleteCustomer(customerId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	
	//step 5: activate validation by apply @Valid before customer in post method and
	//update method
	
	//add 
	@PostMapping("customer")
	public ResponseEntity<Customer>  addAnCustomer(@Valid  @RequestBody Customer customer){
		Customer customerAdded=customerService.addCustomer(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body(customer);
	}
	
	
	//update
	@PutMapping("customer/{customerId}")
	public ResponseEntity<Customer>  updateAnCustomer
	(@PathVariable(name = "customerId")int customerId, @Valid @RequestBody Customer customer){
		Customer customerUpdated=customerService.updateCustomer(customerId, customer);
		return ResponseEntity.status(HttpStatus.OK).body(customerUpdated);
	}
}