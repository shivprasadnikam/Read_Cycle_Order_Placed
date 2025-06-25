package com.example.read.cycle.order.placed.consumer;

import com.example.read.cycle.order.placed.dto.OrderPlacedEventDto;
import com.example.read.cycle.order.placed.service.InventoryService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private InventoryService inventoryService;

    @KafkaListener(topics = "order-placed", groupId = "order-service-group")
    public void consumeOrderPlaced(String message) {
        try {
            // Deserialize JSON message to OrderPlacedEventDto object
            OrderPlacedEventDto event = objectMapper.readValue(message, OrderPlacedEventDto.class);
            System.out.println("Received OrderPlacedEventDto for Order ID: " + event.orderId);
            System.out.println("User ID: " + event.userId);
            System.out.println("Total Amount: " + event.totalAmount);

            // TODO: Add further processing, like sending next event to Kafka
            inventoryService.reserveBook(event);
        } catch (Exception e) {
            System.err.println("Failed to process order placed event: " + e.getMessage());
            e.printStackTrace();
            // Optionally, handle retry or dead-letter logic here
        }
    }
    @KafkaListener(topics = "order-status", groupId = "order-service-group")
    public void listen(String message) {
        System.out.println("Received message: " +message);
    }
}
