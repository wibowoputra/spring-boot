package com.example.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.hello.service.CalculatorService;

public class CalculatorServiceTest {
    
    CalculatorService calculatorService = new CalculatorService();  

    @Test      
    public void testAdd() {
        int result = calculatorService.add(2, 3);
        assertEquals(5, result);
    }
    
}
