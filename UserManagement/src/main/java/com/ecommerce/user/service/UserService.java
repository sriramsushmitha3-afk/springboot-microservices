package com.ecommerce.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.user.builder.UserBuilder;
import com.ecommerce.user.dao.UserRepository;
import com.ecommerce.user.dto.request.UserCreateRequest;
import com.ecommerce.user.dto.request.UserUpdateRequest;
import com.ecommerce.user.dto.response.UserResponse;
import com.ecommerce.user.exceptions.UserNotFoundException;
import com.ecommerce.user.model.User;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public UserResponse save(UserCreateRequest userCreateRequest) {
		User user = UserBuilder.buildUserFromUserCreateRequest(userCreateRequest);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User savedUser = userRepository.save(user);
		UserResponse userResponseFromUser = UserBuilder.buildUserResponseFromUser(savedUser);
		return userResponseFromUser;
		
	}

	public List<UserResponse> getAllUsers() {
		
		return userRepository.findAll()
					.stream()
					.map(UserBuilder::buildUserResponseFromUser)
					.toList();
		
	}

	public UserResponse getUserById(long userId) {
		 User user=userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("User not found with this id: "+userId));
		
		 return UserBuilder.buildUserResponseFromUser(user);
	}

	public UserResponse updateUserById(long userId, UserUpdateRequest userUpdateRequest) {
		User existingUser = userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("User not found with this id: "+userId));
		User user = UserBuilder.buildUserFromUserUpdateRequest(existingUser,userUpdateRequest);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User savedUser = userRepository.save(user);
		return UserBuilder.buildUserResponseFromUser(savedUser);
		
	}

	public void deleteUserById(long userId) {
		if(!userRepository.existsById(userId)) {
			throw new UserNotFoundException("User not found with id: "+userId);
		}
		userRepository.deleteById(userId);
	}
	
}
