package com.example.hello.service;

import org.springframework.stereotype.Component;

@Component
public class OrderService {
    IPaymentService paymentService;  
    public OrderService(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }
    public void placeOrder(double amount) {
        // Process order logic here
        System.out.println("Order placed for amount: $" + amount);
        paymentService.pay(amount);
    }
}
