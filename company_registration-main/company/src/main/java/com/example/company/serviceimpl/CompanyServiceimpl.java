package com.example.company.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.company.entity.Company;
import com.example.company.repository.CompanyRepository;
import com.example.company.request_transform.CompanyRequestConverter;
import com.example.company.responce_transform.CompanyResponseConverter;
import com.example.company.response.CompanyResponse;
import com.example.company.service.CompanyService;
import com.example.company.request.*;

@Service
@Component
public class CompanyServiceimpl implements CompanyService{
	
	@Autowired
	CompanyRepository companyRepository;
	
	

	@Override
	public CompanyResponse createCompany(CompanyRequest companyRequest) {
		
		Company companyModel =CompanyRequestConverter.toCompanyEntity(companyRequest);
		Company saveCompany = this.companyRepository.save(companyModel);
		return CompanyResponseConverter.convertToResponse(saveCompany);
		
	}
		
}
