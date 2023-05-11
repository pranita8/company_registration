package com.example.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.company.entity.Users;
import com.example.company.repository.menuRepository;
import com.example.company.repository.roleMenuMappingRepository;
import com.example.company.repository.usersRepository;
import com.example.company.repository.usersRoleRepository;
import com.example.company.request.userRequest;
import com.example.company.response.userResponse;

@Service
public interface UserService {
	
	public List<Users> getAllUsers();
    public Users getUserById(Long userId);
    public Users saveUser(Users user);
    public void deleteUser(Long userId);
	userResponse createUser(userRequest userRequest) throws Exception;
	
}
