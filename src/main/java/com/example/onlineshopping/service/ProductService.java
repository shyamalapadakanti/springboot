package com.example.onlineshopping.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.example.onlineshopping.entity.Product;




public interface ProductService {
	List<Product> getAllProducts();
    Optional<Product> getProductById(Integer id);
    byte[] getProductImage(Integer id);
    Product addProduct(String pname, Integer price, MultipartFile imageFile) throws IOException;
	Product save(Product product);
	
	Product findById(Integer id);

}
