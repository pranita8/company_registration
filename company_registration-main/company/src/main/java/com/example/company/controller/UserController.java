package com.example.company.controller;

import org.springframework.beans.factory.annotation.Autowired;


import com.example.company.service.UserService;


public class UserController {
   
	
	@Autowired 
	private UserService userService;
	
//	@GetMapping
//	public List<UserResponse> getAllUsers() {
////		log.info("Getting all users");
//		return userService.getAllUsers();
//	}
}
