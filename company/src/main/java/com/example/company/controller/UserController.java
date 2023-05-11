package com.example.company.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.company.exception.ResourceNotFoundException;
import com.example.company.request.UserRequest;
import com.example.company.response.UserResponse;
import com.example.company.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
   
	
	@Autowired 
	private UserService userService;
	
	@GetMapping
	public List<UserResponse> getAllUsers() {
		return userService.getAllUsers();
	}
	
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserResponse> getUserById(@PathVariable Long userId) throws ResourceNotFoundException {
		log.info("Getting user by id: {}", userId);
		Optional<UserResponse> optionalUser = userService.getUsersById(userId);
		if (optionalUser.isPresent()) {
			return ResponseEntity.ok(optionalUser.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/update/{userId}")
	public String updateUser(@PathVariable Long userId, @RequestBody UserRequest userRequest) {
		log.info("Updating user with id: {}", userId);
		return userService.updateUser(userId, userRequest);
	}

	@PostMapping("/post")
	public UserResponse addUser(@RequestBody UserRequest userRequest) throws ResourceNotFoundException {
		log.info("Adding new user");
		return userService.createUser(userRequest);
	}

	@DeleteMapping("/delete/{userId}")
	public String deleteUser(@PathVariable Long userId) throws ResourceNotFoundException {
		log.info("Deleting user with id: {}", userId);
		return userService.deleteUser(userId);
}
	

//	@GetMapping("/user/{companyId}")
//	public ResponseEntity<List<UserResponse>> getUsersByCompanyId(@PathVariable Long companyId)throws ResourceNotFoundException {
//		log.info("Getting users by company id: {}", companyId);
//		
//		List<UserResponse> users = userService.getUsersByCompanyId(companyId);
//		if (users.isEmpty()) {
//			throw new ResourceNotFoundException("User", "id", companyId);
//		} 
//			return new ResponseEntity<>(users, HttpStatus.OK);
//		
//	}


    @GetMapping("/verify")
    public ResponseEntity<Void> verifyEmail(@RequestParam String email, @RequestParam String code) {
        userService.verifyEmail(email, code);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
