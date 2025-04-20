package com.example.onlineshopping.entity;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

	@Entity
	@Table(name = "ORDERDETAIL")
	
	public class OrderDetail {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer id;
		private Integer totalamount;
		private Integer quantity;
		public Integer getQuantity() {
			return quantity;
		}


		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}


		public Integer getId() {
			return id;
		}


		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getTotalamount() {
			return totalamount;
		}
		public void setTotalamount(Integer totalamount) {
			this.totalamount = totalamount;
		}
	

		


		@ManyToMany
		@JoinTable(
		    name = "order_product",
		    joinColumns = @JoinColumn(name = "order_id"),
		    inverseJoinColumns = @JoinColumn(name = "product_id")
		)
		private List<Product> productList;

		


		public List<Product> getProductList() {
			return productList;
		}


		public CustomerOrder getCustomerorder() {
			return customerorder;
		}

		@ManyToOne
	    @JoinColumn(name = "customerorder_id")
		private CustomerOrder customerorder;
	
		public void setCustomerorder(CustomerOrder customerorder) {
			this.customerorder = customerorder;
		}


		public void setProductList(List<Product> productList) {
			this.productList = productList;
		}


	


		





	

		

	}



