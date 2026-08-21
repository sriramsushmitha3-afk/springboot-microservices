package com.ecommerce.user.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.user.builder.UserBuilder;
import com.ecommerce.user.dao.UserRepository;
import com.ecommerce.user.dto.request.LoginRequest;
import com.ecommerce.user.dto.response.AuthResponse;
import com.ecommerce.user.enums.AccountStatus;
import com.ecommerce.user.exceptions.InvalidUserException;
import com.ecommerce.user.model.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final UserRepository userRepository;
	
	private final PasswordEncoder passwordEncoder;

	public AuthResponse userLogin(LoginRequest loginRequest) {
		
		String email = loginRequest.getEmail();
		User user = userRepository.findByEmail(email).orElseThrow(()->new InvalidUserException("Invalid email or password"));
		AccountStatus accountStatus = user.getAccountStatus();
		if(accountStatus==AccountStatus.INACTIVE) throw new InvalidUserException("Account is inactive");
		if(accountStatus==AccountStatus.BLOCKED) throw new InvalidUserException("Account is blocked");
		String password = loginRequest.getPassword();
		if(!passwordEncoder.matches(password, user.getPassword()) ) {
			throw new InvalidUserException("Invalid email or password");
		}
		return UserBuilder.buildUserAuthLoginResponseFromUser(user);
	
	}
	
	
}
