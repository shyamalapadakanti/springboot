package com.example.onlineshopping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onlineshopping.entity.Customer;





public interface CustomerRepo extends JpaRepository<Customer,Integer>{

	boolean existsById(Integer id);

	void deleteById(Integer id);

}
