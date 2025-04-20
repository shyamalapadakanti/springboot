package com.example.onlineshopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlineshopping.entity.Customer;
import com.example.onlineshopping.repo.CustomerOrderRepo;
import com.example.onlineshopping.repo.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepo customerRepo;
	@Override
	public Customer save(Customer customer) {
		return customerRepo.save(customer);    
	}
	@Override
	public List<Customer> findAll() {
	return customerRepo.findAll();
	      }
	@Override
	public Customer findById(Integer id) {
		return customerRepo.findById(id).get();
	}
	@Override
	 public Customer updateCustomer(Integer id, Customer updatedCustomer) {
        return customerRepo.findById(id).map(customer -> {
            customer.setName(updatedCustomer.getName());
            
            return customerRepo.save(customer);
        }).orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }
	@Override
    public Customer deleteById(Integer id) {
        if (customerRepo.existsById(id)) {
        	customerRepo.deleteById(id);
        } else {
            throw new RuntimeException("Customer not found with id: " + id);
        }
		return null;
    }

	 @Override
	    public Customer getById(Integer id) {
	        Optional<Customer> customer = customerRepo.findById(id);
	        return customer.orElse(null); // Returns customer or null if not found
	    }
	
}
	
	
	 

