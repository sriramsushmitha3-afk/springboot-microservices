package com.ecommerce.delivery.builder;

import com.ecommerce.delivery.dto.request.DeliveryCreateRequest;
import com.ecommerce.delivery.dto.request.DeliveryUpdateRequest;
import com.ecommerce.delivery.dto.response.DeliveryResponse;
import com.ecommerce.delivery.model.Delivery;

public class DeliveryBuilder {

	public static Delivery buildDeliveryFromDeliveryCreateRequest(DeliveryCreateRequest deliveryCreateRequest) {
		return Delivery.builder()
						.estimatedDeliveryDate(deliveryCreateRequest.getEstimatedDeliveryDate())
						.orderId(deliveryCreateRequest.getOrderId())
						.shippingAddress(deliveryCreateRequest.getShippingAddress())
						.status(deliveryCreateRequest.getStatus())
						.trackingNumber(deliveryCreateRequest.getTrackingNumber())
						.build();
						
	}

	public static DeliveryResponse buildDeliveryResponseFromDelivery(Delivery savedDelivery) {
		return DeliveryResponse.builder()
								.deliveryId(savedDelivery.getDeliveryId())
								.actualDeliveryDate(savedDelivery.getActualDeliveryDate())
								.estimatedDeliveryDate(savedDelivery.getEstimatedDeliveryDate())
								.orderId(savedDelivery.getOrderId())
								.shippingAddress(savedDelivery.getShippingAddress())
								.status(savedDelivery.getStatus())
								.trackingNumber(savedDelivery.getTrackingNumber())
								.build();
		
	}

	public static Delivery buildDeliveryFromDeliveryUpdateRequest(Delivery existingDelivery,
			DeliveryUpdateRequest deliveryUpdateRequest) {
				
		return Delivery.builder()
								.deliveryId(existingDelivery.getDeliveryId())
								.estimatedDeliveryDate(deliveryUpdateRequest.getEstimatedDeliveryDate())
								.orderId(existingDelivery.getOrderId())
								.shippingAddress(deliveryUpdateRequest.getShippingAddress())
								.status(deliveryUpdateRequest.getStatus())
								.trackingNumber(existingDelivery.getTrackingNumber())
								.actualDeliveryDate(deliveryUpdateRequest.getActualDeliveryDate())
								.build();
		
		
	}
	
}
