package com.example.hello.event.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.hello.event.ProductCreateEvent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductEventProducer {
    private final KafkaTemplate<String, ProductCreateEvent> kafkaTemplate;
    private static final String TOPIC = "product-order-created";

    public void sendProductCreateEvent(ProductCreateEvent event) {
        try {
            log.info("Sending Product Create Event | productId={}", event.getId());

            kafkaTemplate.send(TOPIC, event.getId().toString(), event)
                .whenComplete((result, ex) -> {
                    if (ex != null) {
                        log.error("❌ Kafka send failed after retries. productId={}, reason={}",
                                event.getId(), ex.getMessage(), ex);
                    } else {
                        log.info("✅ Kafka event sent successfully. topic={}, offset={}",
                                result.getRecordMetadata().topic(),
                                result.getRecordMetadata().offset());
                    }
                }); 
        } catch (Exception e) {
            log.error("Failed to send Product Create Event: {}", e);
        }
        
    }
}
