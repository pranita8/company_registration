package com.example.company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import com.example.company.exception.ResourceNotFoundException;
import com.example.company.request.UserRequest;
import com.example.company.response.UserResponse;


public interface UserService {

	List<UserResponse> getAllUsers();
	Optional<UserResponse> getUsersById(Long userId) throws ResourceNotFoundException;
	String updateUser(Long userId, UserRequest userRequest);
	String deleteUser(Long userId) throws ResourceNotFoundException;
	UserResponse createUser(UserRequest userRequest) throws ResourceNotFoundException;
//	List<UserResponse> getUsersByCompanyId(Long companyId) throws ResourceNotFoundException;
	 public ResponseEntity<String> verifyEmail(String email, String code);
	
}
