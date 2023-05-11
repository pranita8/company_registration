package com.example.company.request;

import com.example.company.entity.UserRole;

import lombok.Getter;

@Getter
public class UserRequest {
	private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private UserRole role;
	private boolean isDeleted;
	private String UserRole;
	private boolean verificationEnabled;
}
