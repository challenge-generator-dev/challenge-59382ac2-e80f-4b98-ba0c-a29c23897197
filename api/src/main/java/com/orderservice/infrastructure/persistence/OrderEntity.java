package com.orderservice.infrastructure.persistence;

import com.orderservice.domain.Order;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    private String id;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "order_items", joinColumns = @JoinColumn(name = "order_id"))
    private List<OrderItemEntity> items;

    private String customerId;

    @Enumerated(EnumType.STRING)
    private Order.OrderStatus status;

    private LocalDateTime createdAt;

    public OrderEntity() {
    }

    public OrderEntity(String id, List<OrderItemEntity> items, String customerId, Order.OrderStatus status, LocalDateTime createdAt) {
        this.id = id;
        this.items = items;
        this.customerId = customerId;
        this.status = status;
        this.createdAt = createdAt;
    }

    public static OrderEntity fromDomain(Order order) {
        List<OrderItemEntity> itemEntities = order.getItems().stream()
                .map(item -> new OrderItemEntity(item.getProductId(), item.getQuantity(), item.getPrice()))
                .collect(Collectors.toList());

        return new OrderEntity(
                order.getId(),
                itemEntities,
                order.getCustomerId(),
                order.getStatus(),
                order.getCreatedAt()
        );
    }

    public Order toDomain() {
        List<Order.OrderItem> orderItems = items.stream()
                .map(item -> new Order.OrderItem(item.getProductId(), item.getQuantity(), item.getPrice()))
                .collect(Collectors.toList());

        Order order = new Order(orderItems, customerId);
        order.setStatus(status);
        return order;
    }

    public String getId() {
        return id;
    }

    public List<OrderItemEntity> getItems() {
        return items;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Order.OrderStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Embeddable
    public static class OrderItemEntity {
        private String productId;
        private int quantity;
        private double price;

        public OrderItemEntity() {
        }

        public OrderItemEntity(String productId, int quantity, double price) {
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