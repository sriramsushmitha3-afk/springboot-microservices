package com.ecommerce.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.products.dto.request.OrderItemCreateRequest;
import com.ecommerce.products.dto.request.OrderItemUpdateRequest;
import com.ecommerce.products.dto.response.OrderItemResponse;
import com.ecommerce.products.service.OrderItemService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/orderitems")
public class OrderItemController {

	@Autowired
	OrderItemService orderItemService;
	
	@PostMapping
	public OrderItemResponse addOrderItem(@RequestBody OrderItemCreateRequest orderItemCreateRequest) {
		
		return orderItemService.addOrderItem(orderItemCreateRequest);
		
	}
	
	@GetMapping
	public List<OrderItemResponse> getAllOrderItems(){
		orderItemService.getAllOrderItems();
		return null;
		
	}
	
	@GetMapping("/{orderItemId}")
	public OrderItemResponse getOrderItemById(@PathVariable long orderItemId) {
		return orderItemService.getOrderItemById(orderItemId);
		
	}
	
	@PutMapping("/{orderItemId}")
	public OrderItemResponse updateOrderItemById(@PathVariable long orderItemId, OrderItemUpdateRequest orderItemUpdateRequest) {
		return orderItemService.updateOrderItemById(orderItemId,orderItemUpdateRequest);	
	}
	
	@DeleteMapping("/{orderItemId}")
	public void deleteOrderItemById(@PathVariable long orderItemId) {
		orderItemService.deleteOrderItem(orderItemId);
	}
	
}
