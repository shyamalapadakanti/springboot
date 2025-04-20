package com.example.onlineshopping.dto;

public class OrderResponse {
	 private Integer totalamount;
	    private String pname;
	    private Integer price;
		public Integer getTotalamount() {
			return totalamount;
		}
		public void setTotalamount(Integer totalamount) {
			this.totalamount = totalamount;
		}
		public String getPname() {
			return pname;
		}
		public OrderResponse(Integer totalamount, String pname, Integer price) {
			super();
			this.totalamount = totalamount;
			this.pname = pname;
			this.price = price;
		}
		public void setPname(String pname) {
			this.pname = pname;
		}
		public OrderResponse() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Integer getPrice() {
			return price;
		}
		public void setPrice(Integer price) {
			this.price = price;
		}
		
	    
}
