package com.ecommerce.delivery.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.delivery.model.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Long>{

	
}
