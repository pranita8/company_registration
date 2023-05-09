package com.example.company.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.company.request.CompanyRequest;
import com.example.company.response.CompanyResponse;
import com.example.company.service.CompanyService;


public class CompanyController {
	
//	@PostMapping("/post")
//	public ResponseEntity<CompanyResponse> createCompany(@RequestBody CompanyRequest companyRequest) {
//		CompanyResponse response = CompanyService.createCompany(companyRequest);
//		return ResponseEntity.ok(response);
//	}
}
