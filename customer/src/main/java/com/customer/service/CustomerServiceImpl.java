package com.customer.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.customer.entities.Customer;
import com.customer.exceptions.CustomerNotFoundException;
import com.customer.repo.CustomerRepo;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public List<Customer> getAll() {
		return customerRepo.findAll();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		customerRepo.save(customer);
		return customer;
	}

	@Override
	public Customer deleteCustomer(int customerId) {
		Customer customerToDelete=getById(customerId);
		customerRepo.delete(customerToDelete);
		return customerToDelete;
	}

	@Override
	public Customer updateCustomer(int customerId, Customer customer) {
		Customer customerToUpdate=getById(customerId);
	
		customerToUpdate.setPhoneNo(customer.getPhoneNo());
		customerToUpdate.setAddress(customer.getAddress());
		customerToUpdate.setEmail(customer.getEmail());
		return customerToUpdate;
	}

	@Override
	public Customer getById(int customerId) {
		Customer customer=customerRepo.findById(customerId)
				.orElseThrow(()-> new CustomerNotFoundException("customer with id "+ customerId +" is not found"));
		return customer;
	}

}
