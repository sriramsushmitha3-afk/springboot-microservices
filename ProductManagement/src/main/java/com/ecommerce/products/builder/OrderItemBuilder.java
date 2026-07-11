package com.ecommerce.products.builder;

import com.ecommerce.products.dto.request.OrderItemCreateRequest;
import com.ecommerce.products.dto.request.OrderItemUpdateRequest;
import com.ecommerce.products.dto.response.OrderItemResponse;
import com.ecommerce.products.model.OrderItem;

public class OrderItemBuilder {
	
	public static OrderItem buildOrderItemFromOrderItemCreateRequest(OrderItemCreateRequest orderItemCreateRequest) {
		return OrderItem.builder()
				.productId(orderItemCreateRequest.getProductId())
				.quantity(orderItemCreateRequest.getQuantity())
				.build();
		
	}

	public static OrderItemResponse buildOrderItemResponseFromOrderItem(OrderItem orderItem) {
		return OrderItemResponse.builder()
						.orderItemId(orderItem.getOrderItemId())
						.orderId(orderItem.getOrder().getOrderId())
						.price(orderItem.getPrice())
						.productId(orderItem.getProductId())
						.quantity(orderItem.getQuantity())
						.build();
		
	}
	
	public static OrderItem buildOrderItemFromOrderItemUpdateRequest(OrderItemUpdateRequest orderItemUpdateRequest) {
		return OrderItem.builder()
						.productId(orderItemUpdateRequest.getProductId())
						.quantity(orderItemUpdateRequest.getQuantity())
						.build();
	}


}
