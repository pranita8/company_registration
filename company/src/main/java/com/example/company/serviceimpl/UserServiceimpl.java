package com.example.company.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.company.repository.usersRepository;
import com.example.company.service.UserService;
import com.example.company.entity.Users;
import com.example.company.entity.UserRole;
import com.example.company.request.userRequest;
import com.example.company.response.userResponse;
import com.example.company.transformer.userRequestConverter;
import com.example.company.transformer.userResponseConverter;

import jakarta.transaction.Transactional;

@Service
public class userServiceImpl implements UserService{
	
	@Autowired
	private usersRepository repository;

	
	@Override
	public userResponse createUser(userRequest userRequest) throws Exception {
	    try {
	        Users user = userRequestConverter.postUsersEntity(userRequest);
//	        String encryptedPassword = passwordEncoder.encode(user.getPassword());
//	        user.setPassword(encryptedPassword);
	        Users savedUser = this.repository.save(user);
	        return userResponseConverter.convertToResponse(savedUser);
	    } catch (Exception e) {
	        // Handle exception
	        throw new Exception("Error occurred while creating new user", e);
	    }
	}
	
	
	

    @Override
    public List<Users> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public Users getUserById(Long userId) {
        Optional<Users> user = repository.findById(userId);
        return user.orElse(null);
    }

    @Override
    public Users saveUser(Users user) {
        return repository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
    	repository.deleteById(userId);
    }

}
