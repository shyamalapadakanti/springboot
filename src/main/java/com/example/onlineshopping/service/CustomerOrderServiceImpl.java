package com.example.onlineshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlineshopping.entity.CustomerOrder;
import com.example.onlineshopping.repo.CustomerOrderRepo;






@Service
public  class CustomerOrderServiceImpl implements CustomerOrderService{
	@Autowired
	CustomerOrderRepo custorderRepo;
	@Override
	public CustomerOrder save(CustomerOrder customerorder) {
		return custorderRepo.save(customerorder);    
	}
	@Override
	public List<CustomerOrder> findAll() {
	return custorderRepo.findAll();
	      }
	 @Override
	  public CustomerOrder findById(Integer id) {
	    return custorderRepo.findById(id).get();
	  }
	
	}


