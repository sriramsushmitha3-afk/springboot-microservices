package com.ecommerce.products.builder;

import java.time.LocalDateTime;
import java.util.List;

import com.ecommerce.products.dto.request.OrderCreateRequest;
import com.ecommerce.products.dto.request.OrderItemUpdateRequest;
import com.ecommerce.products.dto.request.OrderUpdateRequest;
import com.ecommerce.products.dto.response.OrderItemResponse;
import com.ecommerce.products.dto.response.OrderResponse;
import com.ecommerce.products.model.Order;

public class OrderBuilder {
	
	public static Order buildOrderByOrderCreateRequest(OrderCreateRequest orderCreateRequest ) {
		 Order order = Order.builder()
			.orderItems(orderCreateRequest.getOrderItems().stream().map(OrderItemBuilder::buildOrderItemFromOrderItemCreateRequest).toList())
			.userId(orderCreateRequest.getUserId())
			.build();
		 
		 linkOrderItems(order);
		 
		 return order;
			
	}
	
	public static void linkOrderItems(Order order) {
		order.getOrderItems().forEach(item->item.setOrder(order));
	}
	
	
	public static OrderResponse buildOrderResponseFromOrder(Order order) {
		List<OrderItemResponse> orderItems = order.getOrderItems().stream().map(OrderItemBuilder::buildOrderItemResponseFromOrderItem).toList();
		return OrderResponse.builder()
					.orderDate(order.getOrderDate())
					.orderId(order.getOrderId())
					.orderItems(orderItems)
					.status(order.getStatus())
					.totalPrice(order.getTotalPrice())
					.userId(order.getUserId())
					.build();
		
	}



}
