package com.example.onlineshopping.model;



import java.util.Date;

import com.example.onlineshopping.entity.CustomerOrder;
import com.example.onlineshopping.entity.Product;





public class OrderDetailModel {
	private  Integer totalamount;
	private  Date orderdate;
	private Integer count;

private String pname;
private Integer price;
public Integer getTotalamount() {
	return totalamount;
}
public void setTotalamount(Integer totalamount) {
	this.totalamount = totalamount;
}
public Date getOrderdate() {
	return orderdate;
}
public void setOrderdate(Date orderdate) {
	this.orderdate = orderdate;
}
public Integer getCount() {
	return count;
}
public void setCount(Integer count) {
	this.count = count;
}


public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public Integer getPrice() {
	return price;
}
public void setPrice(Integer price) {
	this.price = price;
}
public Product setProductList(Product productList) {
	// TODO Auto-generated method stub
	return productList;
}



	

}
