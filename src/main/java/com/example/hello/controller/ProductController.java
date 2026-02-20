package com.example.hello.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hello.Entity.ProductRequest;
import com.example.hello.exception.ProductNotFoundException;
import com.example.hello.model.Product;
import com.example.hello.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //create product
    @PostMapping()
    public Product createProduct(@Valid @RequestBody ProductRequest product) {
        Product newProduct = new Product();
        newProduct.setName(product.getName());  
        newProduct.setPrice(product.getPrice());
        newProduct.setId(product.getId());
        return productService.createProduct(newProduct);
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
