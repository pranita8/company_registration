package com.example.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.company.entity.UserRole;
import com.example.company.entity.Users;
import com.example.company.repository.usersRepository;
import com.example.company.repository.usersRoleRepository;
import com.example.company.request.userRequest;
import com.example.company.response.userResponse;
import com.example.company.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
//	@PostMapping("/users")
//	public Users createUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String password, @RequestParam boolean isDeleted, @RequestParam Long roleId) {
//	    return userService.createUser( firstName, lastName, email, password, isDeleted, roleId);
//	}
	
//	@PostMapping("/add")
//    public ResponseEntity<userResponse> addUser(@RequestBody userRequest userRequest) throws Exception {
//        userResponse user = userService.createUser(userRequest);
//        return ResponseEntity.ok(user);
//    }
    
    @GetMapping("/")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public Users getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/")
    public Users saveUser(@RequestBody Users user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
    
    @Autowired
    private usersRoleRepository repository;
    
    @Autowired
    private usersRepository userRepository;
 
    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody Users user) {
        Long roleId = user.getRole().getRoleId();
        UserRole role = repository.findById(roleId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid role ID: " + roleId));
        user.setRole(role);
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }
	
}
