package com.example.restservice.models;

import java.util.UUID;

public class Order {
    
    private UUID id;
    private int productId;
    private boolean paid;

    public Order()
    {
        id = UUID.randomUUID();
    }

    public Order(int productId) {
        this();
        this.productId = productId;
    }

    public UUID getId() {
        return id;
    }

    public int getProductId() {
        return productId;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
