package com.ecommerce.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.inventory.dto.request.InventoryCreateRequest;
import com.ecommerce.inventory.dto.request.InventoryUpdateRequest;
import com.ecommerce.inventory.dto.response.InventoryResponse;
import com.ecommerce.inventory.service.InventoryService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	@Autowired
	InventoryService inventoryService;
	
	@PostMapping
	public InventoryResponse addInventory(@RequestBody InventoryCreateRequest inventoryCreateRequest ) {
		return inventoryService.addInventory(inventoryCreateRequest);
		
	}
	
	@GetMapping
	public List<InventoryResponse> getAllInventories(){
		return inventoryService.getAllInventories();
	}
	
	@GetMapping("/{inventoryId}")
	public InventoryResponse getInventoryById(@PathVariable long inventoryId) {
		return inventoryService.getInventoryById(inventoryId);
		
	}
	
	@PutMapping("/{inventoryId}")
	public InventoryResponse updateInventoryById(@PathVariable long inventoryId,@RequestBody InventoryUpdateRequest inventoryUpdateRequest) {
		return inventoryService.updateInventoryById(inventoryId,inventoryUpdateRequest);
	}
	
	@DeleteMapping("/{inventoryId}")
	public void deleteInventoryById(@PathVariable long inventoryId) {
		inventoryService.deleteInventoryById(inventoryId);
	}

}
