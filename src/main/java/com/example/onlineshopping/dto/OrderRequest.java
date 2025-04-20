package com.example.onlineshopping.dto;

import com.example.onlineshopping.entity.OrderDetail;

public class OrderRequest {
	private OrderDetail orderdetail;

	public OrderDetail getOrderdetail() {
		return orderdetail;
	}

	public void setOrderdetail(OrderDetail orderdetail) {
		this.orderdetail = orderdetail;
	}

}
