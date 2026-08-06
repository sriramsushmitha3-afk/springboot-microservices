package com.ecommerce.user.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequest {
	
	@NotBlank(message = "User Name is required")
	@Size(min = 3, max = 50, message = "username length should be within 3 - 50")
	private String userName;
	
	@NotBlank(message = "email is required")
	@Email(message = "enter valid email")
	private String email;
	
	@NotBlank(message = "password is required")
	@Size(min = 8,message = "password minimum length is 8 ")
	private String password;
	
	@NotBlank(message = "phone number is required" )
	@Pattern(regexp = "^[6-9][0-9]{9}$", message="Phone number must contain exactly 10 digits")
	private String phoneNum;
	
	@Valid
	private AddressCreateRequest address;

}
