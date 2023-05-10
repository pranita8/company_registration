package com.example.company.responce_transform;

import com.example.company.entity.Users;
import com.example.company.response.UserResponse;

public class UserResponseConverter {

	public static UserResponse convertToResponse(Users userEntity) {
		
		UserResponse userResponse = new UserResponse();
		
		userResponse.setFirstName(userEntity.getFirstName());
		userResponse.setLastName(userEntity.getLastName());	
		userResponse.setEmail(userEntity.getEmail());
		userResponse.setPassword(userEntity.getPassword());
		userResponse.setDeleted(userEntity.isDeleted());
		userResponse.setUserId(userEntity.getUserId());
		
		return userResponse;
	}

}
