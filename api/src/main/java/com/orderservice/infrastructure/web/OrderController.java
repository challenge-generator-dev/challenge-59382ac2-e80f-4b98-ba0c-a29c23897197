package com.orderservice.infrastructure.web;

import com.orderservice.application.OrderService;
import com.orderservice.application.OrderService.OrderItemRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody CreateOrderRequest request) {
        List<OrderItemRequest> itemRequests = request.getItems().stream()
                .map(dto -> new OrderItemRequest(dto.getProductId(), dto.getQuantity(), dto.getPrice()))
                .collect(Collectors.toList());

        var order = orderService.createOrder(itemRequests, request.getCustomerId());
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponse(order));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable String id) {
        var order = orderService.getOrder(id);
        return ResponseEntity.ok(toResponse(order));
    }

    private OrderResponse toResponse(com.orderservice.domain.Order order) {
        List<OrderItemResponse> itemResponses = order.getItems().stream()
                .map(item -> new OrderItemResponse(item.getProductId(), item.getQuantity(), item.getPrice()))
                .collect(Collectors.toList());

        return new OrderResponse(
                order.getId(),
                itemResponses,
                order.getCustomerId(),
                order.getStatus().name(),
                order.getCreatedAt().toString()
        );
    }

    public static class CreateOrderRequest {
        private List<OrderItemRequestDto> items;
        private String customerId;

        public CreateOrderRequest() {
        }

        public CreateOrderRequest(List<OrderItemRequestDto> items, String customerId) {
            this.items = items;
            this.customerId = customerId;
        }

        public List<OrderItemRequestDto> getItems() {
            return items;
        }

        public void setItems(List<OrderItemRequestDto> items) {
            this.items = items;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }
    }

    public static class OrderItemRequestDto {
        private String productId;
        private int quantity;
        private double price;

        public OrderItemRequestDto() {
        }

        public OrderItemRequestDto(String productId, int quantity, double price) {
            this.productId = productId;
            this.quantity = quantity;
            this.price = price;
        }

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

    public static class OrderResponse {
        private String id;
        private List<OrderItemResponse> items;
        private String customerId;
        private String status;
        private String createdAt;

        public OrderResponse() {
        }

        public OrderResponse(String id, List<OrderItemResponse> items, String customerId, String status, String createdAt) {
            this.id = id;
            this.items = items;
            this.customerId = customerId;
            this.status = status;
            this.createdAt = createdAt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<OrderItemResponse> getItems() {
            return items;
        }

        public void setItems(List<OrderItemResponse> items) {
            this.items = items;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }
    }

    public static class OrderItemResponse {
        private String productId;
        private int quantity;
        private double price;

        public OrderItemResponse() {
        }

        public OrderItemResponse(String productId, int quantity, double price) {
            this.productId = productId;
            this.quantity = quantity;
            this.price = price;
        }

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}