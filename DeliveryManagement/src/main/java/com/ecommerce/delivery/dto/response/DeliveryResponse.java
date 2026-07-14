package com.ecommerce.delivery.dto.response;

import java.time.LocalDate;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryResponse {

	private long deliveryId;
	
	private long orderId;
	
	private String trackingNumber;

	private String shippingAddress;
	
	private LocalDate estimatedDeliveryDate;
	
	private LocalDate actualDeliveryDate;
	
	private String status;
}
