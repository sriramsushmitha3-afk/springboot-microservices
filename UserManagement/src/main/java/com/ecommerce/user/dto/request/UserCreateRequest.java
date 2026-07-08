package com.ecommerce.user.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequest {
	
	private String userName;
	private String email;
	private String password;
	private String phoneNum;
	private AddressCreateRequest address;

}
