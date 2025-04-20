package com.example.onlineshopping.repo;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.onlineshopping.dto.OrderResponse;
import com.example.onlineshopping.entity.OrderDetail;






public interface OrderDetailRepo extends JpaRepository<OrderDetail,Integer>{
	 @Query("SELECT new com.example.onlineshopping.dto.OrderResponse(c.totalamount , p.pname, p.price) FROM OrderDetail c JOIN c.productList p")
	    public List<OrderResponse> getJoinInformation();
	 
}
