package com.example.read.cycle.order.placed.serviceImpl;

import com.example.read.cycle.order.placed.dto.OrderPlacedEventDto;
import com.example.read.cycle.order.placed.entity.OrderAuditLogEntity;
import com.example.read.cycle.order.placed.repository.OrderAuditLogRepository;
import com.example.read.cycle.order.placed.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    OrderAuditLogRepository orderAuditLogRepository;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "order-status";

    public void reserveBook(OrderPlacedEventDto orderPlacedEventDto){
        OrderAuditLogEntity orderAuditLogEntity = new OrderAuditLogEntity();
        orderAuditLogEntity.setBookId(orderPlacedEventDto.getBookId());
        orderAuditLogEntity.setOrderId(orderPlacedEventDto.getOrderId());
        orderAuditLogEntity.setUserId(orderPlacedEventDto.getUserId());
        orderAuditLogRepository.save(orderAuditLogEntity);

    }


    public void sendToKafka(String message) {
        kafkaTemplate.send(TOPIC, message);
    }
}
