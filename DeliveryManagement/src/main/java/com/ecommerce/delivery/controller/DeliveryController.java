package com.ecommerce.delivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.delivery.dto.request.DeliveryCreateRequest;
import com.ecommerce.delivery.dto.request.DeliveryUpdateRequest;
import com.ecommerce.delivery.dto.response.DeliveryResponse;
import com.ecommerce.delivery.service.DeliveryService;

import lombok.Builder;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

	@Autowired
	DeliveryService deliveryService;
	
	@PostMapping
	public DeliveryResponse assignDelivery(@RequestBody DeliveryCreateRequest deliveryCreateRequest) {
		
		return deliveryService.assignDelivery(deliveryCreateRequest);	
		
	}
	
	@GetMapping
	public List<DeliveryResponse> getAllDeliveries(){
		
		return deliveryService.getAllDeliveries();
		
	}
	
	@GetMapping("/{deliveryId}")
	public DeliveryResponse getDeliveryById(@PathVariable long deliveryId) {
		return deliveryService.getDeliveryById(deliveryId);
		
	}
	
	@PutMapping("/{deliveryId}")
	public DeliveryResponse updateDeliveryById(@PathVariable long deliveryId, @RequestBody DeliveryUpdateRequest deliveryUpdateRequest) {
		
		return deliveryService.updateDeliveryById(deliveryId,deliveryUpdateRequest);
		
	}
	
}
