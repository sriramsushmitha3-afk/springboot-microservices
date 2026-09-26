package com.ecommerce.user.dto.request;

import com.ecommerce.user.model.Address;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateOwnProfileRequest {

	@NotBlank(message = "User Name is required")
	@Size(min = 3, max = 50, message = "username length should be within 3 - 50")
	private String userName;
	
	@NotBlank(message = "Phone Number is required")
	@Pattern(regexp = "^[6-9][0-9]{9}$", message="Phone number must contain exactly 10 digits")
	private String phoneNum;
	
	@Valid
	private AddressUpdateRequest address;
}
