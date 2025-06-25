package com.example.read.cycle.order.placed.service;

import com.example.read.cycle.order.placed.dto.OrderPlacedEventDto;
import org.springframework.stereotype.Service;

@Service
public interface InventoryService {
    public void reserveBook(OrderPlacedEventDto orderPlacedEventDto);
}
