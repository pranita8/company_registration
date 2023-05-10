package com.example.company.response;

import java.util.List;
import com.example.company.entity.Users;
import lombok.Data;

@Data
public class CompanyResponse {
	    private Long companyId;
	    private String companyName;
	    private String phoneNumber;
	    private String emailId;
	    private String address;
	    private Boolean isDeleted;
		private List<Users> users;
}
