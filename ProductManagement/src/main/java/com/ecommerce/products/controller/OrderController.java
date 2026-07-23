package com.ecommerce.products.controller;

import com.ecommerce.products.dao.OrderRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.products.dto.request.OrderCreateRequest;
import com.ecommerce.products.dto.request.OrderUpdateRequest;
import com.ecommerce.products.dto.response.OrderResponse;
import com.ecommerce.products.service.OrderService;


@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	OrderService orderService;

	@PostMapping
	public OrderResponse addOrder(@RequestBody OrderCreateRequest orderCreateRequest) {
		
		return orderService.addOrder(orderCreateRequest);
	}
	
	@GetMapping
	public List<OrderResponse> getAllOrders(){
		return orderService.getAllOrders();
		
	}
	
	@GetMapping("/{orderId}")
	public OrderResponse getOrderById(@PathVariable long orderId ) {
		return orderService.getOrderById(orderId);
	
	}
	
	@PutMapping("/{orderId}")
	public OrderResponse updateOrderById(@PathVariable long orderId,@RequestBody OrderUpdateRequest orderUpdateRequest) {
		return orderService.updateOrderById(orderId,orderUpdateRequest);
		
	}
	
	@DeleteMapping("/{orderId}")
	public void deleteOrderById(@PathVariable long orderId) {
		orderService.deleteOrderById(orderId);
	}
}
