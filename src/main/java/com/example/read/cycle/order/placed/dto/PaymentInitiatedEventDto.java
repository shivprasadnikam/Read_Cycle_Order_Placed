package com.example.read.cycle.order.placed.dto;

public class PaymentInitiatedEventDto {
    public String orderId;
    public double amount;

    public PaymentInitiatedEventDto(String orderId, double amount) {
        this.orderId = orderId;
        this.amount = amount;
    }
}
