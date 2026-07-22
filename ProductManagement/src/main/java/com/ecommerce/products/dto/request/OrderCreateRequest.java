package com.ecommerce.products.dto.request;

import java.util.List;

import com.ecommerce.products.model.OrderItem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateRequest {

	private long userId;
	
	private List<OrderItemCreateRequest> orderItems;
	
}
