package com.ecommerce.inventory.builder;

import com.ecommerce.inventory.dto.request.InventoryCreateRequest;
import com.ecommerce.inventory.dto.request.InventoryUpdateRequest;
import com.ecommerce.inventory.dto.response.InventoryResponse;
import com.ecommerce.inventory.model.Inventory;

public class InventoryBuilder {
	
	public static Inventory buildInventoryFromInventoryCreateRequest(InventoryCreateRequest inventoryCreateRequest) {
		return Inventory.builder().availableQuantity(inventoryCreateRequest.getAvailableQuantity())
						.productId(inventoryCreateRequest.getProductId())
						.reserveQuantity(inventoryCreateRequest.getReserveQuantity())
						.warehouse(inventoryCreateRequest.getWarehouse())
						.build();
		
	}
	
	public static InventoryResponse buildInventoryResponseFromInventory(Inventory inventory) {
		return InventoryResponse.builder().inventoryId(inventory.getInventoryId())
										.availableQuantity(inventory.getAvailableQuantity())
										.productId(inventory.getProductId())
										.reserveQuantity(inventory.getReserveQuantity())
										.warehouse(inventory.getWarehouse())
										.build();
	}

	public static Inventory buildInventoryFromInventoryUpdateRequest(Inventory existingInventory,
			InventoryUpdateRequest inventoryUpdateRequest) {
		
		return Inventory.builder()
				.inventoryId(existingInventory.getInventoryId())
				.productId(existingInventory.getProductId())
				.availableQuantity(inventoryUpdateRequest.getAvailableQuantity())
				.reserveQuantity(inventoryUpdateRequest.getReserveQuantity())
				.warehouse(inventoryUpdateRequest.getWarehouse())
				.build();
		
		
		
	
		
	}

}
