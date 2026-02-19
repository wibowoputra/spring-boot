package com.example.hello.service;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.example.hello.model.Product;

@Service
public class ProductService {
    Map<Long, Product> productRepo = new HashMap<>();
    Long idCounter = 3L; // Starting ID for new products

    //Create Product
    public Product createProduct(Product product) {
        product.setId(idCounter++);
        productRepo.put(product.getId(), product);
        return product;
    }

    //Read Product
    public Product getProductById(Long id) {
        return productRepo.get(id);
    }
    //read all products
    public Map<Long, Product> getAllProducts() {    
        return productRepo;
    }
    //update product
    public Product updateProduct(Long id, Product updatedProduct) {
        if (productRepo.containsKey(id)) {
            updatedProduct.setId(id);
            productRepo.put(id, updatedProduct);
            return updatedProduct;
        }
        return null; // or throw an exception
    }
    //delete product
    public boolean deleteProduct(Long id) {   
        return productRepo.remove(id) != null;
    }   
}
