package com.ecommerce.products.dto.request;

import java.util.List;

public class OrderUpdateRequest {

	private long userId;
	
	private double totalPrice;
	
	private String status;
	
	private List<OrderItemCreateRequest> orderItems;
}
