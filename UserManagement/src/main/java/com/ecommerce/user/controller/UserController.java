package com.ecommerce.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.user.dao.UserRepository;
import com.ecommerce.user.dto.request.UserCreateRequest;
import com.ecommerce.user.dto.request.UserRoleStatusUpdateRequest;
import com.ecommerce.user.dto.request.UserUpdateRequest;
import com.ecommerce.user.dto.response.UserResponse;
import com.ecommerce.user.service.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping
	public UserResponse saveUser(@Valid @RequestBody UserCreateRequest userCreateRequest ) {
		return userService.save(userCreateRequest);
		
	}
	
	@GetMapping
	public List<UserResponse> getAllUsers(){
		return userService.getAllUsers();
		
	}

	
	@GetMapping("/{userId}")
	public UserResponse getUserById(@PathVariable long userId) {
		
		return userService.getUserById(userId);
		
	}
	
	@PutMapping("/{userId}")
	public UserResponse updateUserById(@PathVariable long userId,@Valid @RequestBody UserUpdateRequest userUpdateRequest ) {
		return userService.updateUserById(userId,userUpdateRequest);
		
	}
	
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable long userId) {
		userService.deleteUserById(userId);
	}
	
	@PutMapping("/{userId}/role-status")
	public UserResponse updateUserRoleStatusById(@PathVariable long userId, @Valid @RequestBody UserRoleStatusUpdateRequest request) {
		return userService.updateUserRoleStatusById(userId,request);
		
	}
	
	
	@GetMapping("/me")
	public UserResponse getSelfUser() {
		
		return userService.getSelfUser();
		
	}
	
}
