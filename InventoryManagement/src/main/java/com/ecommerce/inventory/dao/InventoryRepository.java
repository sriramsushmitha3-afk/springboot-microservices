package com.ecommerce.inventory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.inventory.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}
