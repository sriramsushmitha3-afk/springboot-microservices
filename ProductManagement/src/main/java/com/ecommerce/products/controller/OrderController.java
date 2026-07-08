package com.ecommerce.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.products.dto.request.OrderCreateRequest;
import com.ecommerce.products.dto.response.OrderResponse;
import com.ecommerce.products.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping
	public OrderResponse addOrder(OrderCreateRequest orderCreateRequest) {
		
		return orderService.addOrder(orderCreateRequest);
	}
	
	@GetMapping
	public List<OrderResponse> getAllOrders(){
		orderService.getAllOrders();
		return null;
		
	}
	
	
}
