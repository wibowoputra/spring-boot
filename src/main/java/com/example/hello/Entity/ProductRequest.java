package com.example.hello.Entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import jakarta.validation.constraints.Min;

@Data
public class ProductRequest {
    @Min(18L) 
    private Long id;
    @NotBlank(message = "Name is required")
    private String name;
    @Min(100L) 
    private double price;

    
}