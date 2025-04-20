package com.example.onlineshopping.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.onlineshopping.entity.Customer;
import com.example.onlineshopping.entity.CustomerOrder;
import com.example.onlineshopping.service.CustomerOrderService;
import com.example.onlineshopping.service.CustomerService;
import com.example.onlineshopping.service.ProductService;


@CrossOrigin("http://localhost:3000")
@RestController
public class CustomerOrderControlller {
	@Autowired
	  CustomerOrderService customerorderService;
	@Autowired
	  ProductService productService;
	@Autowired
	  CustomerService customerService;

	  @PostMapping("/customerorder/{customerId}/save")
	    public ResponseEntity<?> saveOrder(@PathVariable("customerId") Integer id, @RequestBody CustomerOrder customerorder) {
	        Map<String, Object>  respOrder = new LinkedHashMap<String, Object>();
	          Customer customer=customerService.findById(id);
	       customerorder.setCustomer(customer);
	       customerorderService.save(customerorder);
	        respOrder.put("status", 1);
	        respOrder.put("message", "Record is Saved Successfully!");
	        return new ResponseEntity<>(respOrder , HttpStatus.CREATED);
	    }  


	  @GetMapping("/getorder")
	  public ResponseEntity <?> getCustomerOrders() {
	    Map <String, Object> model = new LinkedHashMap <String, Object>();
	   
		List <CustomerOrder> customerorderList = customerorderService.findAll();
	    if (!customerorderList.isEmpty()) {
	      model.put("status", 1);
	      model.put("customerorder", customerorderList);
	      return new ResponseEntity < > (model, HttpStatus.OK);
	    } else {
	      model.clear();
	      model.put("status", 0);
	      model.put("message", "Data is not found");
	      return new ResponseEntity < >(model, HttpStatus.NOT_FOUND);
	    }
	  }
}
