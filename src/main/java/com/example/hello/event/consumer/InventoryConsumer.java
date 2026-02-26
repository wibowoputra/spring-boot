package com.example.hello.event.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.hello.event.ProductCreateEvent;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InventoryConsumer {
    @KafkaListener(topics = "product-order-created", groupId = "inventory-group")
    public void consumeProductCreateEvent(ProductCreateEvent event) {
        log.info("Received Product Create Event: {}", event);
        
        log.info(" Before Product Create Do Cek Stock: {}", event);
        log.info(" Product Create Do Add Inventory: {}", event);
        // Here you can add logic to update inventory based on the product creation event
    }
}
