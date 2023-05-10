package com.example.company.request;

import java.util.List;

import com.example.company.entity.Users;

import lombok.Getter;

@Getter
public class CompanyRequest {
	
	  private Long companyId;
	    private String companyName;
	    private String phoneNumber;
	    private String emailId;
	    private String address;
	    private Boolean isDeleted;
		private List<Users> users;
}
