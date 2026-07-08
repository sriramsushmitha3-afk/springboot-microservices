package com.ecommerce.products.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductUpdateRequest {

	private String productName;
	private String description;
	private String brand;
	private double price;
	private double rating;
}
