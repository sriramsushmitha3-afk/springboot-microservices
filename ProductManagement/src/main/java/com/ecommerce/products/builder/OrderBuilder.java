package com.ecommerce.products.builder;

import java.time.LocalDateTime;

import com.ecommerce.products.dto.request.OrderCreateRequest;
import com.ecommerce.products.dto.request.OrderItemUpdateRequest;
import com.ecommerce.products.dto.request.OrderUpdateRequest;
import com.ecommerce.products.dto.response.OrderResponse;
import com.ecommerce.products.model.Order;

public class OrderBuilder {
	
	public static Order buildOrderByOrderCreateRequest(OrderCreateRequest orderCreateRequest ) {
		 Order order = Order.builder()
			.orderItems(orderCreateRequest.getOrderItems().stream().map(OrderItemBuilder::buildOrderItemFromOrderItemCreateRequest).toList())
			.status(orderCreateRequest.getStatus())
			.userId(orderCreateRequest.getUserId())
			.build();
		 
		 linkOrderItems(order);
		 
		 return order;
			
	}
	
	public static void linkOrderItems(Order order) {
		order.getOrderItems().forEach(item->item.setOrder(order));
	}
	
	public static OrderResponse buildOrderResponseFromOrder(Order order) {
		return OrderResponse.builder()
					.orderDate(order.getOrderDate())
					.orderId(order.getOrderId())
					.orderItems(order.getOrderItems())
					.status(order.getStatus())
					.totalPrice(order.getTotalPrice())
					.userId(order.getUserId())
					.build();
		
	}



}
