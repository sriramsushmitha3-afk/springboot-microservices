package com.ecommerce.products.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateRequest {

	private String productName;
	
	private String description;
	
	private String brand;
	
	private double price;
	
	private double rating;
}
