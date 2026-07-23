package com.ecommerce.products.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import com.ecommerce.products.model.OrderItem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {
	
	private long orderId;
	
	private long userId;
	
	private String userName;
	
	private double totalPrice;
	
	private String status;
	
	private LocalDateTime orderDate;
	
	private List<OrderItemResponse> orderItems;
}
