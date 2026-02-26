package com.example.hello.kafka;

import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;

import com.example.hello.event.ProductCreateEvent;
import com.example.hello.event.consumer.InventoryConsumer;
import org.springframework.boot.test.mock.mockito.SpyBean;   

@SpringBootTest
@EmbeddedKafka(
    partitions = 1, 
    topics = { "product-order-created" } 
    // brokerProperties = {
    //     "listeners=PLAINTEXT://localhost:9092", "port=9092" }
    )
public class InventoryConsumerTest {

    @Autowired
    private KafkaTemplate<String, ProductCreateEvent> kafkaTemplate;

    // @Spy
    @SpyBean
    private InventoryConsumer inventoryConsumer;

    @Test
    public void testConsumeProductCreateEvent() throws InterruptedException {
        // Given
        ProductCreateEvent event = new ProductCreateEvent();
        event.setId("1");
        event.setName("Test Product");
        event.setPrice(100.0);

        // When
        kafkaTemplate.send("product-order-created", event.getId().toString(), event);

        // Then
        Thread.sleep(2000); // Wait for the consumer to process the message

        // Verify that the consumer method was called with the correct event
        org.mockito.Mockito.verify(inventoryConsumer)
        .consumeProductCreateEvent(event);
    }
    
}