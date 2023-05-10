package com.example.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.company.request.CompanyRequest;
import com.example.company.response.CompanyResponse;
import com.example.company.service.CompanyService;

@RestController
public class CompanyController {
	
	
	@Autowired
	CompanyService companyService;
	@PostMapping("/register")
	public ResponseEntity<CompanyResponse> signUp(@RequestBody CompanyRequest companyRequest) {
		CompanyResponse response = companyService.createCompany(companyRequest);
		return ResponseEntity.ok(response);
	}	
}
