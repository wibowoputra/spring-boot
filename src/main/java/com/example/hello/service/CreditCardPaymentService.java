package com.example.hello.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
// @Primary
public class CreditCardPaymentService implements IPaymentService {
    @Override
    public void pay(double amount) {
        // Implement credit card payment logic here
        System.out.println("Credit card payment of $" + amount + " processed.");
    }
    
}
