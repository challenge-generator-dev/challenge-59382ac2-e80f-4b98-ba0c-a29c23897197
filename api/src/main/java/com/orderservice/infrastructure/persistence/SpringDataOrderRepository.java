package com.orderservice.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataOrderRepository extends JpaRepository<OrderEntity, String> {
}