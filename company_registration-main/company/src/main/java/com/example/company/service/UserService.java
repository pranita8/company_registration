package com.example.company.service;

import com.example.company.request.UserRequest;
import com.example.company.response.UserResponse;

public interface UserService{
	
	public UserResponse addUser(UserRequest userRequest);
}
