package com.example.hello.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hello.Entity.ProductRequest;
import com.example.hello.event.ProductCreateEvent;
import com.example.hello.event.producer.ProductEventProducer;
import com.example.hello.exception.ProductNotFoundException;
import com.example.hello.model.Product;
import com.example.hello.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final  ProductEventProducer productEventProducer;
    
    //create product
    @PostMapping()
    public ResponseEntity<String> createProduct(@Valid @RequestBody ProductRequest product) {
      
        log.info("Received Product Create Request: {}", product);

        Product newProduct2 = new Product();
        newProduct2.setName(product.getName()); 
        newProduct2.setPrice(product.getPrice());
        productService.createProduct(newProduct2);
        log.info("Product Created: {}", newProduct2);

        ProductCreateEvent productCreateEvent = new ProductCreateEvent();
        productCreateEvent.setName(newProduct2.getName());  
        productCreateEvent.setPrice(newProduct2.getPrice());
        productCreateEvent.setId(newProduct2.getId().toString());
        log.info("Publishing Product Create Event: {}", productCreateEvent);

        productEventProducer.sendProductCreateEvent(productCreateEvent);
        log.info("Product Create Event Published: {}", productCreateEvent);
        return ResponseEntity.ok("Product created successfully");
        // return productService.createProduct(newProduct);
    }
    //read product
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        if(id == 99L) {
            throw new ProductNotFoundException(id);
        }
        return productService.getProductById(id);
    }

    //read all products
    @GetMapping()   
    public Map<Long, Product> getAllProducts() {
        return productService.getAllProducts();
    }
    //update product
    @PostMapping("/{id}")   
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }
    //delete product
    @DeleteMapping("/{id}")
    public boolean deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}
