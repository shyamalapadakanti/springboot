package com.example.onlineshopping.service;

import java.util.List;
import java.util.Optional;

import com.example.onlineshopping.entity.Customer;


public interface CustomerService {
	Customer save(Customer customer);
	List<Customer> findAll();
	Customer findById(Integer id);
	Customer deleteById(Integer id);
	Customer updateCustomer(Integer id, Customer updatedCustomer);
	
	Customer getById(Integer id);
	
	
	}

