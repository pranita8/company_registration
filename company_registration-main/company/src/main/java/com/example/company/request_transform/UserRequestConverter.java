package com.example.company.request_transform;

import java.util.List;
import java.util.stream.Collectors;

import com.example.company.entity.Users;
import com.example.company.request.UserRequest;

public class UserRequestConverter {

	public static Users toUserEntity(UserRequest userRequest) {
		Users userModel = new Users();

		userModel.setFirstName(userRequest.getFirstName());
		userModel.setUserId(userRequest.getUserId());
		userModel.setLastName(userRequest.getLastName());
		userModel.setPassword(userRequest.getPassword());
		
		return userModel;
		
	}
//	public List<Users> toUserEntityList(List<Users> userList) {
//
//		return userList.stream()
//				.map(p -> new Users(p.getUserId(), p.getFirstName(), p.getLastName(), p.getPassword(), p.getCompany(), p.getUserId(), p.getUserRole()))
//				.collect(Collectors.toList());
//
//	}

}
