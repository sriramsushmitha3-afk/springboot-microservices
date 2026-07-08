package com.ecommerce.products.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemResponse {
	
	private long orderItemId;
	
	private long orderId;
	
	private long productId;
	
	private int quantity;
	
	private double price;

}
