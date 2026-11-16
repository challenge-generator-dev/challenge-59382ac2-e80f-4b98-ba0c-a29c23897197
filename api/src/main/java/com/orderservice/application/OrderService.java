package com.orderservice.application;

import com.orderservice.domain.Order;
import com.orderservice.domain.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(List<OrderItemRequest> items, String customerId) {
        List<Order.OrderItem> orderItems = items.stream()
                .map(item -> new Order.OrderItem(item.getProductId(), item.getQuantity(), item.getPrice()))
                .collect(Collectors.toList());

        Order order = new Order(orderItems, customerId);
        return orderRepository.save(order);
    }

    public Order getOrder(String id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + id));
    }

    public static class OrderItemRequest {
        private String productId;
        private int quantity;
        private double price;

        public OrderItemRequest(String productId, int quantity, double price) {
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

    public static class OrderNotFoundException extends RuntimeException {
        public OrderNotFoundException(String message) {
            super(message);
        }
    }
}