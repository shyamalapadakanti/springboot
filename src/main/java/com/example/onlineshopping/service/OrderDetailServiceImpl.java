package com.example.onlineshopping.service;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlineshopping.dto.OrderResponse;
import com.example.onlineshopping.entity.CustomerOrder;
import com.example.onlineshopping.entity.OrderDetail;
import com.example.onlineshopping.entity.Product;
import com.example.onlineshopping.repo.CustomerOrderRepo;
import com.example.onlineshopping.repo.OrderDetailRepo;
import com.example.onlineshopping.repo.ProductRepo;

import jakarta.transaction.Transactional;
@Service
public class OrderDetailServiceImpl implements OrderDetailService{
	@Autowired
	OrderDetailRepo orderdetailRepo;
	 @Autowired
	    private CustomerOrderRepo customerOrderRepo;

	    @Autowired
	    private ProductRepo productRepo;
	@Override
	public OrderDetail save(OrderDetail orderdetail) {
		return orderdetailRepo.save(orderdetail);    
	}

	@Override
	public List<OrderResponse> getJoinInformation() {
		return orderdetailRepo.getJoinInformation();
	}
	 @Override
	    @Transactional  // Ensures Hibernate session is active
	    public List<OrderDetail> findAll() {
	        List<OrderDetail> orderDetails = orderdetailRepo.findAll();
	        
	        // Force loading of productList to avoid LazyInitializationException
	        orderDetails.forEach(order -> order.getProductList().size());

	        return orderDetails;
	    }

	   

	    @Override
	    @Transactional
	    public OrderDetail findById(Integer id) {
	        return orderdetailRepo.findById(id)
	                .orElseThrow(() -> new RuntimeException("OrderDetail not found with id: " + id));
	    }	
	    @Override
	    public Map<String, Object> saveOrderDetail(Integer customerOrderId, OrderDetail orderDetail) {
	        Map<String, Object> response = new LinkedHashMap<>();

	        // Check if Customer Order exists
	        CustomerOrder customerOrder = customerOrderRepo.findById(customerOrderId).orElse(null);
	        if (customerOrder == null) {
	            response.put("status", 0);
	            response.put("message", "Customer order not found!");
	            return response;
	        }
	        orderDetail.setCustomerorder(customerOrder);

	        // Validate Products
	        List<Product> validProducts = new ArrayList<>();
	        for (Product product : orderDetail.getProductList()) {
	            if (product.getId() == null) {
	                response.put("status", 0);
	                response.put("message", "Product ID cannot be null!");
	                return response;
	            }

	            Product existingProduct = productRepo.findById(product.getId()).orElse(null);
	            if (existingProduct == null) {
	                response.put("status", 0);
	                response.put("message", "Product with ID " + product.getId() + " not found!");
	                return response;
	            }
	            validProducts.add(existingProduct);
	        }

	        orderDetail.setProductList(validProducts);

	        // Save OrderDetail
	        orderdetailRepo.save(orderDetail);

	        response.put("status", 1);
	        response.put("message", "Order detail saved successfully!");
	        return response;
	    }

	}

