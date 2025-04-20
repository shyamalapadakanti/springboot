package com.example.onlineshopping.service;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.onlineshopping.dto.OrderResponse;
import com.example.onlineshopping.entity.OrderDetail;
import com.example.onlineshopping.entity.Product;

import jakarta.transaction.Transactional;

public interface OrderDetailService {
	OrderDetail save(OrderDetail orderdetail);
	List<OrderDetail> findAll();
	OrderDetail findById(Integer id);
	List<OrderResponse> getJoinInformation();
	Map<String, Object> saveOrderDetail(Integer customerOrderId, OrderDetail orderDetail);
	
}
