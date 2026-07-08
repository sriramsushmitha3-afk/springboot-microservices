package com.ecommerce.products.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.products.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
