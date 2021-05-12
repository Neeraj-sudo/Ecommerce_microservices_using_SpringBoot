package com.customer.service;
import java.util.*;

import com.customer.entities.Customer;
public interface CustomerService {
	List<Customer> getAll();
	public Customer addCustomer(Customer customer);
	public Customer deleteCustomer(int customerId);
	public Customer updateCustomer(int customerId, Customer customer);
	public Customer getById(int customerId);
}
