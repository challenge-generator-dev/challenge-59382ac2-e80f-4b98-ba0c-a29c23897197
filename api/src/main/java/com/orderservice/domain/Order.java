package com.orderservice.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Order {
    private String id;
    private List<OrderItem> items;
    private String customerId;
    private OrderStatus status;
    private LocalDateTime createdAt;

    public Order(List<OrderItem> items, String customerId) {
        this.id = UUID.randomUUID().toString();
        this.items = List.copyOf(items);
        this.customerId = customerId;
        this.status = OrderStatus.CREATED;
        this.createdAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public List<OrderItem> getItems() {
        return List.copyOf(items);
    }

    public String getCustomerId() {
        return customerId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public enum OrderStatus {
        CREATED, PROCESSING, COMPLETED, CANCELLED
    }

    public static class OrderItem {
        private String productId;
        private int quantity;
        private double price;

        public OrderItem(String productId, int quantity, double price) {
            this.productId = productId;
            this.quantity = quantity;
            this.price = price;
        }

        public String getProductId() {
            return productId;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getPrice() {
            return price;
        }
    }
}