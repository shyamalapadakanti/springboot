package com.example.onlineshopping.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.onlineshopping.entity.Product;
import com.example.onlineshopping.model.ProductModel;
import com.example.onlineshopping.repo.ProductRepo;
import com.example.onlineshopping.service.CustomerOrderService;

import com.example.onlineshopping.service.ProductService;




@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/products")

public class ProductController {

    @Autowired
    private ProductRepo productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<byte[]> getProductImage(@PathVariable Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent() && product.get().getImage() != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            return new ResponseEntity<>(product.get().getImage(), headers, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Product> addproduct(
            @RequestParam("pname") String pname,
            @RequestParam("price") Integer price,
            @RequestParam("image") MultipartFile imageFile) {
        try {
            Product product = new Product();
            product.setPname(pname);
            product.setPrice(price);
            product.setImage(imageFile.getBytes());

            Product savedProduct = productRepository.save(product);
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }





@PutMapping("/updateproduct/{id}")
public ResponseEntity<Product> updateProduct(
        @PathVariable Integer id,
        @RequestParam("pname") String pname,
        @RequestParam("price") Integer price,
        @RequestParam(value = "image", required = false) MultipartFile imageFile) {
    try {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setPname(pname);
            product.setPrice(price);
            if (imageFile != null && !imageFile.isEmpty()) {
                product.setImage(imageFile.getBytes());
            }
            productRepository.save(product);
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    } catch (IOException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
}