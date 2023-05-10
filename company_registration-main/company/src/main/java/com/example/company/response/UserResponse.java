package com.example.company.response;

import com.example.company.entity.UserRole;
import com.example.company.entity.Users;

import lombok.Data;

@Data
public class UserResponse {
	
	    private Long userId;
	    private String firstName;
	    private String lastName;
	    private String email;
	    private String password;
	    private Users user;
	    private UserRole userRole;
		private boolean isDeleted;
}
