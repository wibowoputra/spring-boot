package com.example.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hello.service.CalculatorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/calculator")
@RequiredArgsConstructor
public class CalculatorController {
    
    private final CalculatorService calculatorService;    

    @GetMapping("/add") 
    public String add(@RequestParam int a, @RequestParam  int b) {
        return String.valueOf(a + b);     
    }

}
