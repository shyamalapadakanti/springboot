package com.example.onlineshopping.controller;

import org.springframework.http.MediaType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.onetooneexample.entity.Customer;
////import com.example.onetooneexample.entity.Customer;
//import com.example.onetooneexample.entity.CustomerOrder;
//import com.example.onetooneexample.entity.OrderDetail;
//import com.example.onetooneexample.entity.Product;
////import com.example.onetooneexample.model.CustomerOrderModel;
//import com.example.onetooneexample.model.OrderDetailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.onlineshopping.dto.OrderRequest;
import com.example.onlineshopping.dto.OrderResponse;
import com.example.onlineshopping.entity.CustomerOrder;
import com.example.onlineshopping.entity.OrderDetail;
import com.example.onlineshopping.entity.Product;
import com.example.onlineshopping.repo.OrderDetailRepo;
import com.example.onlineshopping.service.CustomerOrderService;
import com.example.onlineshopping.service.OrderDetailService;
import com.example.onlineshopping.service.ProductService;

@CrossOrigin("http://localhost:3000")
@RestController
public class OrderDetailController {
	@Autowired
	  OrderDetailService orderdetailService;
	@Autowired
	OrderDetailRepo orderdetailRepo;
	@Autowired
	  CustomerOrderService customerorderService;
	
	@Autowired
	  ProductService productService;

	  @GetMapping("/getorderdetail")
	  public ResponseEntity <?> getCustomerOrderDetails() {
	    Map <String, Object> model = new LinkedHashMap <String, Object>();
	    List <OrderDetail> orderdetailList = orderdetailService.findAll();
	    if (!orderdetailList.isEmpty()) {
	      model.put("status", 1);
	      model.put("data", orderdetailList);
	      return new ResponseEntity < > (model, HttpStatus.OK);
	    } else {
	      model.clear();
	      model.put("status", 0);
	      model.put("message", "Data is not found");
	      return new ResponseEntity < >(model, HttpStatus.NOT_FOUND);
	    }
	  }

	    @PostMapping("/placeOrder")
	    public OrderDetail placeOrder(@RequestBody OrderRequest request){
	       return orderdetailService.save(request.getOrderdetail());
	    }
	    @GetMapping("/findAllOrders")
	    public List<OrderDetail> findAllOrders(){
	        return orderdetailService.findAll();
	    }

	    @GetMapping("/getInfo")
	    public List<OrderResponse> getJoinInformation(){
	        return orderdetailService.getJoinInformation();
	    }
	    
	    @PostMapping("/orderdetail/{customerorderId}/save")
	    public ResponseEntity<Map<String, Object>> saveOrderDetail(
	            @PathVariable("customerorderId") Integer id,
	            @RequestBody OrderDetail orderDetail) {

	        Map<String, Object> response = orderdetailService.saveOrderDetail(id, orderDetail);
	        HttpStatus status = (Integer) response.get("status") == 1 ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	        return new ResponseEntity<>(response, status);
	    }
}
