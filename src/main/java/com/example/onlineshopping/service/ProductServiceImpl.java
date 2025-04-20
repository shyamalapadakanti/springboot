package com.example.onlineshopping.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.onlineshopping.entity.Product;
import com.example.onlineshopping.repo.ProductRepo;



@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
    ProductRepo productRepository;

   @Override
   public List<Product> getAllProducts() {
       return productRepository.findAll();
   }

   @Override
   public Optional<Product> getProductById(Integer id) {
       return productRepository.findById(id);
   }

   @Override
   public byte[] getProductImage(Integer id) {
       Optional<Product> product = productRepository.findById(id);
       return product.map(Product::getImage).orElse(null);
   }
   @Override
   public Product findById(Integer id) {
	    return productRepository.findById(id).orElse(null);
	}

   @Override
   public Product addProduct(String pname, Integer price, MultipartFile imageFile) throws IOException {
       Product product = new Product();
       product.setPname(pname);
       product.setPrice(price);
       product.setImage(imageFile.getBytes());
       return productRepository.save(product);
   }
   @Override
   public Product save(Product product) {
       return productRepository.save(product);
   }


   
}
