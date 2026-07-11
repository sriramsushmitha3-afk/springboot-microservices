package com.ecommerce.products.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecommerce.products.builder.OrderBuilder;
import com.ecommerce.products.builder.OrderItemBuilder;
import com.ecommerce.products.dao.OrderRepository;
import com.ecommerce.products.dto.request.OrderCreateRequest;
import com.ecommerce.products.dto.request.OrderUpdateRequest;
import com.ecommerce.products.dto.response.OrderResponse;
import com.ecommerce.products.model.Order;
import com.ecommerce.products.model.OrderItem;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	
	public OrderResponse addOrder(OrderCreateRequest orderCreateRequest) {
		Order order = OrderBuilder.buildOrderByOrderCreateRequest(orderCreateRequest);
		order.setOrderDate(LocalDateTime.now());
		order.setTotalPrice(calculateTotalPrice(order.getOrderItems()));
		Order savedOrder = orderRepository.save(order);
		OrderResponse orderResponseFromOrder = OrderBuilder.buildOrderResponseFromOrder(savedOrder);
		return orderResponseFromOrder;
		
		
	}
	private double calculateTotalPrice(List<OrderItem> orderItems) {
		
		double total=0;
		
		for(OrderItem item: orderItems) {
			total+=item.getPrice()*item.getQuantity();
		}
		return total;
	}
	
	public List<OrderResponse> getAllOrders() {
		 return orderRepository.findAll()
		 				.stream()
		 				.map(OrderBuilder::buildOrderResponseFromOrder)
		 				.toList();
	}
	
	public OrderResponse getOrderById(Long orderId) {
		Order order = orderRepository.findById(orderId).orElseThrow(()->new RuntimeException("Order not found with id: "+orderId));
		return OrderBuilder.buildOrderResponseFromOrder(order);
	}
	
	public OrderResponse updateOrderById(long orderId, OrderUpdateRequest orderUpdateRequest) {
		Order existingOrder = orderRepository.findById(orderId)
											.orElseThrow(()->new RuntimeException("Order not found with id: "+orderId));
		existingOrder.setStatus(orderUpdateRequest.getStatus());
		
		List<OrderItem> updatedItems = orderUpdateRequest.getOrderItems().stream().map(OrderItemBuilder::buildOrderItemFromOrderItemUpdateRequest).toList();
		
		existingOrder.getOrderItems().clear();
		existingOrder.getOrderItems().addAll(updatedItems);
		
		OrderBuilder.linkOrderItems(existingOrder);
		
		existingOrder.setTotalPrice(calculateTotalPrice(existingOrder.getOrderItems()));
		
		Order savedOrder = orderRepository.save(existingOrder);
		
		return OrderBuilder.buildOrderResponseFromOrder(savedOrder);
	}
	public void deleteOrderById(long orderId) {
		if(!orderRepository.existsById(orderId)) {
			throw new RuntimeException("Order not found with Id: "+ orderId);
		}
		orderRepository.deleteById(orderId);
		
	}
	
	

}
