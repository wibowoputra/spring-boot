package com.example.hello.event.consumer;

import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.KafkaListener;

import lombok.extern.slf4j.Slf4j;
import com.example.hello.event.ProductCreateEvent;

@Service
@Slf4j
public class PaymentConsumer {
    @KafkaListener(topics = "product-order-created", groupId = "payment-group")
    public void consumeProductCreateEvent(ProductCreateEvent event) {   
        log.info("Received Product Create Event: {}", event);
        
        log.info(" Before Product Create Do Cek Payment: {}", event);
        log.info(" Product Create Do Add Payment: {}", event);
        // Here you can add logic to update payment based on the product creation event
    }
}
