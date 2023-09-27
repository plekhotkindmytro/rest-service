package com.example.restservice.models;

public class Product {
    
    private int id;
    private String name;
    private long price;
    private String description;
    private boolean available;
    private int quantity;

    public Product() {
        this.available = true;
    }

    public Product(int id, String name, long price, String description, int quantity) {
        this();
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getPrice(){
        return price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setQuanity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuanity() {
        return quantity;
    }
}
