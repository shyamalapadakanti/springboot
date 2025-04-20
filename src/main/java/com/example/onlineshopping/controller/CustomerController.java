package com.example.onlineshopping.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.onlineshopping.entity.Customer;
import com.example.onlineshopping.model.CustomerModel;
import com.example.onlineshopping.service.CustomerService;


@CrossOrigin("http://localhost:3000")
@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;
	

	  @GetMapping("/customerlist")
	  public ResponseEntity <?> getPosts() {
	    Map <String, Object> respMap = new LinkedHashMap < String, Object>();
	    List<Customer> customerlist = customerService.findAll();
	    if (!customerlist.isEmpty()) {
	      respMap.put("status", 1);
	      respMap.put("data", customerlist);
	      return new ResponseEntity< >(respMap, HttpStatus.OK);
	    } else {
	      respMap.clear();
	      respMap.put("status", 0);
	      respMap.put("message", "customer is not found");
	      return new ResponseEntity< >(respMap, HttpStatus.NOT_FOUND);
	    }
	  }
	
	  @PostMapping("/savecustomer")
	  public ResponseEntity <?> savecustomer(@RequestBody CustomerModel custModel) {
	    Map <String, Object> model = new LinkedHashMap < String, Object > ();
	    //creating employee object and setting properties
	    Customer customer = new Customer();
	    customer.setName(custModel.getName());
	    customerService.save(customer);
	   
	    model.put("status", 1);
	    model.put("message", " customer is Saved Successfully!");
	    return new ResponseEntity < > (model, HttpStatus.CREATED);
	  }
	  @GetMapping("/customerlist/{id}")
	    public Customer getById(@PathVariable Integer id) {
	        return customerService.getById(id);
	    }



}
