package com.ecommerce.products.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.products.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
