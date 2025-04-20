package com.example.onlineshopping.service;

import java.util.List;

import com.example.onlineshopping.entity.CustomerOrder;





public interface CustomerOrderService {
	CustomerOrder save(CustomerOrder customerorder);
	List<CustomerOrder> findAll();
	CustomerOrder findById(Integer id);
	}

