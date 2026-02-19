package com.example.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hello.service.CalculatorService;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {
    
    CalculatorService calculatorService;    

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

        @GetMapping("/add") 
    public int add(@RequestParam int a, @RequestParam  int b) {
        return calculatorService.add(a, b);     
    }

}
