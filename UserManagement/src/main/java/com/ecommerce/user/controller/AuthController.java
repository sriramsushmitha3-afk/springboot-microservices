package com.ecommerce.user.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.user.dto.request.LoginRequest;
import com.ecommerce.user.dto.response.AuthResponse;
import com.ecommerce.user.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;
	
	@PostMapping("/login")
	public AuthResponse userLogin(@Valid @RequestBody LoginRequest loginRequest) {
		
		return authService.userLogin(loginRequest);
		
	}
}
