package com.ecommerce.inventory.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inventory")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long inventoryId;
	
	private long productId;
	
	private int availableQuantity;
	
	private int reserveQuantity;
	
	private String warehouse;

	public Inventory(long productId, int availableQuantity, int reserveQuantity, String warehouse) {
		super();
		this.productId = productId;
		this.availableQuantity = availableQuantity;
		this.reserveQuantity = reserveQuantity;
		this.warehouse = warehouse;
	}
	
	
}
