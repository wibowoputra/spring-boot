package com.example.hello.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PaypalPaymentService implements IPaymentService {
    @Override
    public void pay(double amount) {
        // Implement PayPal payment logic here
        System.out.println("PayPal payment of $" + amount + " processed.");
    }

}
