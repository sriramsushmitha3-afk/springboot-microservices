package com.ecommerce.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.inventory.builder.InventoryBuilder;
import com.ecommerce.inventory.dao.InventoryRepository;
import com.ecommerce.inventory.dto.request.InventoryCreateRequest;
import com.ecommerce.inventory.dto.request.InventoryUpdateRequest;
import com.ecommerce.inventory.dto.response.InventoryResponse;
import com.ecommerce.inventory.model.Inventory;

@Service
public class InventoryService {

	@Autowired
	InventoryRepository inventoryRepository;
	
	public InventoryResponse addInventory(InventoryCreateRequest inventoryCreateRequest) {
		Inventory inventory = InventoryBuilder.buildInventoryFromInventoryCreateRequest(inventoryCreateRequest);
		Inventory savedInventory = inventoryRepository.save(inventory);
		InventoryResponse inventoryResponseFromInventory = InventoryBuilder.buildInventoryResponseFromInventory(savedInventory);
		return inventoryResponseFromInventory;
	}

	public List<InventoryResponse> getAllInventories() {
		return inventoryRepository.findAll().stream().map(InventoryBuilder::buildInventoryResponseFromInventory).toList();
		
	}

	public InventoryResponse getInventoryById(long inventoryId) {
		Inventory inventory = inventoryRepository.findById(inventoryId).orElseThrow(()->new RuntimeException("Inventory not found with Id: "+inventoryId));
		return InventoryBuilder.buildInventoryResponseFromInventory(inventory);
	}

	public InventoryResponse updateInventoryById(long inventoryId, InventoryUpdateRequest inventoryUpdateRequest) {
		Inventory existingInventory = inventoryRepository.findById(inventoryId).orElseThrow(()->new RuntimeException("Inventory not found with Id: "+inventoryId));
		Inventory inventory = InventoryBuilder.buildInventoryFromInventoryUpdateRequest(existingInventory, inventoryUpdateRequest);
		Inventory savedInventory = inventoryRepository.save(inventory);
		
		return InventoryBuilder.buildInventoryResponseFromInventory(savedInventory);
	}

	public void deleteInventoryById(long inventoryId) {
		if(!inventoryRepository.existsById(inventoryId)) {
			throw new RuntimeException("Inventory not found with Id: "+inventoryId);
		}
		
		inventoryRepository.deleteById(inventoryId);
	}

}
