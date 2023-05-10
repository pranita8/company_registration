package com.example.company.request;

import com.example.company.entity.UserRole;
import com.example.company.entity.Users;

import lombok.Getter;

@Getter
public class UserRequest {
	
	private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean isDeleted;
    private Users user;
    
    private UserRole userRole;

}
