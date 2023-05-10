package com.example.company.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.company.entity.Users;

import com.example.company.repository.UserRepository;

import com.example.company.request.UserRequest;
//import com.example.company.request_transform.CompanyRequestConverter;
import com.example.company.request_transform.UserRequestConverter;
//import com.example.company.responce_transform.CompanyResponseConverter;
import com.example.company.responce_transform.UserResponseConverter;
//import com.example.company.response.CompanyResponse;
import com.example.company.response.UserResponse;
import com.example.company.service.UserService;

public class UserServiceimpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserResponse addUser(UserRequest userRequest) {
		
		
		
			Users userModel = UserRequestConverter.toUserEntity(userRequest);
			Users saveUser = this.userRepository.save(userModel);
			return UserResponseConverter.convertToResponse(saveUser);
			
		
	}

}
