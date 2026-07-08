package com.ecommerce.products.builder;

import com.ecommerce.products.dto.request.OrderItemCreateRequest;
import com.ecommerce.products.dto.request.OrderItemUpdateRequest;
import com.ecommerce.products.dto.response.OrderItemResponse;
import com.ecommerce.products.model.OrderItem;

public class OrderItemBuilder {
	
	public static OrderItem buildOrderItemFromOrderItemCreateRequest(OrderItemCreateRequest orderItemCreateRequest) {
		return OrderItem.builder()
				.productId(orderItemCreateRequest.getProductId())
				.price(orderItemCreateRequest.getPrice())
				.quantity(orderItemCreateRequest.getQuantity())
				.build();
		
	}

	public static OrderItemResponse buildOrderItemResponseFromOrderItem(OrderItem orderItem) {
		return OrderItemResponse.builder()
						.orderItemId(orderItem.getOrderItemId())
						.orderId(orderItem.getOrderId())
						.price(orderItem.getPrice())
						.productId(orderItem.getProductId())
						.quantity(orderItem.getQuantity())
						.build();
		
	}
	
	public static OrderItem buildOrderItemFromOrderUpdateRequest(OrderItem existOrderItem,OrderItemUpdateRequest orderItemUpdateRequest) {
		return OrderItem.builder()
						.orderItemId(existOrderItem.getOrderItemId())
						.orderId(existOrderItem.getOrderId())
						.productId(orderItemUpdateRequest.getProductId())
						.quantity(orderItemUpdateRequest.getQuantity())
						.price(orderItemUpdateRequest.getPrice())
						.build();
	}


}
