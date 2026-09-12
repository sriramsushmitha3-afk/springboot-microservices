package com.ecommerce.user.builder;

import com.ecommerce.user.dto.request.AddressCreateRequest;
import com.ecommerce.user.dto.request.AddressUpdateRequest;
import com.ecommerce.user.dto.request.UserCreateRequest;
import com.ecommerce.user.dto.request.UserUpdateRequest;
import com.ecommerce.user.dto.response.AddressResponse;
import com.ecommerce.user.dto.response.AuthResponse;
import com.ecommerce.user.dto.response.UserResponse;
import com.ecommerce.user.enums.AccountStatus;
import com.ecommerce.user.enums.Role;
import com.ecommerce.user.model.Address;
import com.ecommerce.user.model.User;

public class UserBuilder {

	public static User buildUserFromUserCreateRequest(UserCreateRequest userCreateRequest) {
		return User.builder()
			.userName(userCreateRequest.getUserName())
			.email(userCreateRequest.getEmail())
			.password(userCreateRequest.getPassword())
			.phoneNum(userCreateRequest.getPhoneNum())
			.address(buildAddressFromAddressCreateRequest(userCreateRequest.getAddress()))
			.role(Role.CUSTOMER)
			.accountStatus(AccountStatus.ACTIVE)
			.build();
		
	}
	
	public static User buildUserFromUserUpdateRequest(User existingUser,UserUpdateRequest userUpdateRequest) {
		return User.builder()
					.userId(existingUser.getUserId())
					.userName(userUpdateRequest.getUserName())
					.email(userUpdateRequest.getEmail())
					.password(userUpdateRequest.getPassword())
					.phoneNum(userUpdateRequest.getPhoneNum())
					.address(buildAddressFromAddressUpdateRequest(existingUser.getAddress(), userUpdateRequest.getAddress()))
					.role(existingUser.getRole())
					.accountStatus(existingUser.getAccountStatus())
					.build();
	}
	
	public static Address buildAddressFromAddressCreateRequest(AddressCreateRequest addressCreateRequest) {
		return Address.builder()
			.city(addressCreateRequest.getCity())
			.country(addressCreateRequest.getCountry())
			.pincode(addressCreateRequest.getPincode())
			.state(addressCreateRequest.getState())
			.street(addressCreateRequest.getStreet())
			.build();
		
	}
	
	public static Address buildAddressFromAddressUpdateRequest(Address existingAddress,AddressUpdateRequest addressUpdateRequest) {
		return Address.builder()
			.addressId(existingAddress.getAddressId())
			.city(addressUpdateRequest.getCity())
			.country(addressUpdateRequest.getCountry())
			.pincode(addressUpdateRequest.getPincode())
			.state(addressUpdateRequest.getState())
			.street(addressUpdateRequest.getStreet())
			.build();
	}
	
	public static UserResponse buildUserResponseFromUser(User user) {
		return UserResponse.builder()
				.userId(user.getUserId())
				.userName(user.getUserName())
				.email(user.getEmail())
				.phoneNum(user.getPhoneNum())
				.address(buildAddressResponseFromAddress(user.getAddress()))
				.role(user.getRole())
				.accountStatus(user.getAccountStatus())
				.build();
		
	}
	
	public static AddressResponse buildAddressResponseFromAddress(Address address) {
		return AddressResponse.builder()
				.addressId(address.getAddressId())
				.city(address.getCity())
				.country(address.getCountry())
				.pincode(address.getPincode())
				.street(address.getStreet())
				.state(address.getState())
				.build();
		
	}
	
	public static AuthResponse buildUserAuthLoginResponseFromUser(User user, String token) {
		return AuthResponse.builder()
				.userId(user.getUserId())
				.userName(user.getUserName())
				.email(user.getEmail())
				.role(user.getRole())
				.accountStatus(user.getAccountStatus())	
				.token(token)
				.build();
		
	}
	
	
}
