package com.example.hello.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentService implements IPaymentService {
    @Override
    public void pay(double amount) {
        // Implement payment logic here
        System.out.println("Payment of $" + amount + " processed.");
    }
}
