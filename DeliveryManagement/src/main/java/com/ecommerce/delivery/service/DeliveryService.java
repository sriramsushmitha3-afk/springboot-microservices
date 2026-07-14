package com.ecommerce.delivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.delivery.builder.DeliveryBuilder;
import com.ecommerce.delivery.dao.DeliveryRepository;
import com.ecommerce.delivery.dto.request.DeliveryCreateRequest;
import com.ecommerce.delivery.dto.request.DeliveryUpdateRequest;
import com.ecommerce.delivery.dto.response.DeliveryResponse;
import com.ecommerce.delivery.model.Delivery;

@Service
public class DeliveryService {

	@Autowired
	DeliveryRepository deliveryRepository;
	
	public DeliveryResponse assignDelivery(DeliveryCreateRequest deliveryCreateRequest) {
		Delivery delivery = DeliveryBuilder.buildDeliveryFromDeliveryCreateRequest(deliveryCreateRequest);
		Delivery savedDelivery = deliveryRepository.save(delivery);
		DeliveryResponse deliveryResponseFromDeliveryCreateRequest = DeliveryBuilder.buildDeliveryResponseFromDelivery(savedDelivery);
		
		return deliveryResponseFromDeliveryCreateRequest;
	}

	public List<DeliveryResponse> getAllDeliveries() {

		 List<DeliveryResponse> list = deliveryRepository.findAll().stream().map(DeliveryBuilder::buildDeliveryResponseFromDelivery).toList();
		 
		 return list;
	}

	public DeliveryResponse getDeliveryById(long deliveryId) {
		Delivery delivery = deliveryRepository.findById(deliveryId).orElseThrow(()-> new RuntimeException("Delivery not found with Id : "+ deliveryId));
		return DeliveryBuilder.buildDeliveryResponseFromDelivery(delivery);
	}

	public DeliveryResponse updateDeliveryById(long deliveryId, DeliveryUpdateRequest deliveryUpdateRequest) {
		Delivery existingDelivery = deliveryRepository.findById(deliveryId).orElseThrow(()->new RuntimeException("Delivery not found with Id : "+ deliveryId));
		DeliveryBuilder.buildDeliveryFromDeliveryUpdateRequest(existingDelivery,deliveryUpdateRequest);
		return null;
	}

	
}
