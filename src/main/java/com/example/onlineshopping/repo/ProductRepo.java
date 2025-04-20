package com.example.onlineshopping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onlineshopping.entity.Product;





public interface ProductRepo extends JpaRepository<Product,Integer> {

	

}
