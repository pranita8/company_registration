package com.example.company.request_transform;

import com.example.company.entity.Company;
import com.example.company.request.CompanyRequest;

public class CompanyRequestConverter {
	
	public static Company toCompanyEntity(CompanyRequest company) {

		Company companyModel = new Company();
		
		
		
		companyModel.setCompanyId(company.getCompanyId());
		companyModel.setCompanyName(company.getCompanyName());
		companyModel.setPhoneNumber(company.getPhoneNumber());
		companyModel.setAddress(company.getAddress());
		companyModel.setEmailId(company.getEmailId());
        companyModel.setIsDeleted(company.getIsDeleted());
        companyModel.setUsers(company.getUsers());
        
		return companyModel;

	}

}
