package com.example.company.responce_transform;

import com.example.company.entity.Company;
import com.example.company.response.CompanyResponse;

public class CompanyResponseConverter {

	public static CompanyResponse convertToResponse(Company companyEntity) {
		
		CompanyResponse companyResponse = new CompanyResponse();
		   
		   companyResponse.setCompanyId(companyEntity.getCompanyId());
		   companyResponse.setAddress(companyEntity.getAddress());
		   companyResponse.setCompanyName(companyEntity.getCompanyName());
		   companyResponse.setPhoneNumber(companyEntity.getPhoneNumber());
		   companyResponse.setIsDeleted(companyEntity.getIsDeleted());
		   companyResponse.setEmailId(companyEntity.getEmailId());
		   
//		   companyResponse.setLegalName(companyEntity.);
//		   companyResponse.setPhoneNo(companyEntity.getPhoneNo());
//		   companyResponse.setRegistration(companyEntity.getRegistration());
		   companyResponse.setUsers(companyEntity.getUsers());
//		   companyResponse.setId(companyEntity.getId());
		   
		   return companyResponse;
		
	}

}
