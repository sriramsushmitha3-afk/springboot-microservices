package com.ecommerce.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.products.builder.OrderItemBuilder;
import com.ecommerce.products.dao.OrderItemRepository;
import com.ecommerce.products.dto.request.OrderItemCreateRequest;
import com.ecommerce.products.dto.request.OrderItemUpdateRequest;
import com.ecommerce.products.dto.response.OrderItemResponse;
import com.ecommerce.products.model.OrderItem;

@Service
public class OrderItemService {

//	@Autowired
//	OrderItemBuilder orderItemBuilder;
	
	@Autowired
	OrderItemRepository orderItemRepository;
	
	public OrderItemResponse addOrderItem(OrderItemCreateRequest orderItemCreateRequest) {
		
		OrderItem orderItem = OrderItemBuilder.buildOrderItemFromOrderItemCreateRequest(orderItemCreateRequest);
		OrderItem savedOrderItem = orderItemRepository.save(orderItem);
		OrderItemResponse orderItemResponseFromOrderItem = OrderItemBuilder.buildOrderItemResponseFromOrderItem(savedOrderItem);
		
		return orderItemResponseFromOrderItem;	
	}

	public List<OrderItemResponse> getAllOrderItems() {
		return orderItemRepository.findAll()
						.stream()
						.map(OrderItemBuilder::buildOrderItemResponseFromOrderItem)
						.toList();
	}

	public OrderItemResponse getOrderItemById(long orderItemId) {
		OrderItem orderItem = orderItemRepository.findById(orderItemId).orElseThrow(()->new RuntimeException("OrderItem not found with id:"+orderItemId));
		OrderItemResponse orderItemResponseFromOrderItem = OrderItemBuilder.buildOrderItemResponseFromOrderItem(orderItem);
		return orderItemResponseFromOrderItem;
		
	}

	public OrderItemResponse updateOrderItemById(long orderItemId, OrderItemUpdateRequest orderItemUpdateRequest) {
		OrderItem existOrderItem = orderItemRepository.findById(orderItemId).orElseThrow(()->new RuntimeException("OrderItem not found with id: "+orderItemId));
		OrderItem orderItem = OrderItemBuilder.buildOrderItemFromOrderUpdateRequest(existOrderItem, orderItemUpdateRequest);
		OrderItem savedOrderItem = orderItemRepository.save(orderItem);
		
		return OrderItemBuilder.buildOrderItemResponseFromOrderItem(savedOrderItem);	
	}

	public void deleteOrderItem(long orderItemId) {
		if(!orderItemRepository.existsById(orderItemId)) {
			throw new RuntimeException("OrderItem not found with id: "+orderItemId);
		}
		orderItemRepository.deleteById(orderItemId);
		
	}
	
	

}
