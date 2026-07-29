package com.ecommerce.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressUpdateRequest {

	@NotBlank(message = "street is required")
	private String street;
	
	@NotBlank(message = "city is required")
	private String city;
	
	@NotBlank(message = "pincode is required")
	private String pincode;
	
	@NotBlank(message = "state is required")
	private String state;
	
	@NotBlank(message = "country is required")
	private String country;
}
