package com.example.onlineshopping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onlineshopping.entity.CustomerOrder;




public interface CustomerOrderRepo extends JpaRepository<CustomerOrder,Integer> {

}
