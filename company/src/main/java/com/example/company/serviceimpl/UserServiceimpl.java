package com.example.company.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.example.company.entity.Users;
import com.example.company.exception.ResourceNotFoundException;
import com.example.company.repository.UserRepository;
import com.example.company.request.UserRequest;
import com.example.company.request_transform.UserRequestConverter;
import com.example.company.responce_transform.UserResponseConverter;
import com.example.company.response.UserResponse;
import com.example.company.service.UserService;

@Service
public class UserServiceimpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	 @Autowired
	    private JavaMailSender mailSender;
	 
	// Store the verification codes in a map
    private HashMap<String, String> verificationCodes = new HashMap<>();
//	@Autowired
//	private UserRole userRole;
	@Override
	public List<UserResponse> getAllUsers() {
		List<Users> users = userRepository.findAll();
		return users.stream().map(UserResponseConverter::convertToResponse).collect(Collectors.toList());
	}

	@Override
	public Optional<UserResponse> getUsersById(Long userId) throws ResourceNotFoundException {  
	Optional<Users> userOptional = userRepository.findById(userId);
		if (userOptional.isPresent()) {
			UserResponse userResponse = UserResponseConverter.convertToResponse(userOptional.get());
			return Optional.of(userResponse);
		} else {
			throw new ResourceNotFoundException("User", "id", userId);
		}
	}

	@Override
	public String updateUser(Long userId, UserRequest userRequest) {
		Optional<Users> optionalUser = userRepository.findById(userId);
		if (optionalUser.isPresent()) {
			Users user = optionalUser.get();
//			Company company = userRequest.getCompany();
//			if (company != null) {
//				if (company.getIsDeleted()) {
//					return "Cannot update user with a deleted company.";
//				} else {
//					user.setCompany(company);
//				}
//			}
			UserRequestConverter.updateEntity(user, userRequest);
			userRepository.save(user);
			return "User updated successfully.";	
		}
//			if(userRole.getUserRole()=="admin")
//			{
//				UserRequestConverter.updateEntity(user, userRequest);
//				userRepository.save(user);
//				return "User updated successfully.";	
//			}
//			else {
//				return "Cannot update user.";
//			}
//		}
		 else {
			return "User not found.";
		}
	}

	@Override
	public String deleteUser(Long userId) throws ResourceNotFoundException {

		try {
			Optional<Users> optionalUser = userRepository.findById(userId);
			if (optionalUser.isPresent()) {
				Users user = optionalUser.get();
				user.setDeleted(true);
				user.isDeleted();
				userRepository.save(user);
				return "delete user successfull";
			} else {
				throw new ResourceNotFoundException("User", "id", userId);
			}
		} catch (Exception ex) {

			throw new ResourceNotFoundException("User", "id", userId);
		}

	}

//	@Override

	public UserResponse createUser(UserRequest userRequest) throws ResourceNotFoundException {
//		if (userRequest.getCompany() != null && !userRequest.getCompany().getIsDeleted()) {
//			Company company = companyRepository.findById(userRequest.getCompany().getCompanyId()).orElseThrow(
//					() -> new ResourceNotFoundException("Company", "id", userRequest.getCompany().getCompanyId()));

			Users user = UserRequestConverter.toEntity(userRequest);
//			user.setCompany(company);

			Users savedUser = userRepository.save(user);
			System.out.println("data saved");
			System.out.println("going to email meth");
			  sendVerificationEmail(user);
			  return UserResponseConverter.convertToResponse(savedUser);
//		}
//		throw new ResourceNotFoundException("Company", "id", userRequest.getCompany().getCompanyId());
	}
	 private void sendVerificationEmail(Users user) {
	        // Generate a random verification code
		 String verificationCode = UUID.randomUUID().toString().substring(0, 4);
			System.out.println("token genrated : "+verificationCode);
			
	        // Store the verification code in the map
	        verificationCodes.put(user.getEmail(), verificationCode);
	        System.out.println("saved in hash set"+verificationCodes);
	        // Send the verification email
	        String subject = "Verify your email address";
	        String message = "Please click on the following link to verify your email address: "
	            + "http://localhost:8082/users/verify?email=" + user.getEmail() + "&code=" + verificationCode;
	        System.out.println("mail genrated");
	        sendEmail(user.getEmail(), subject, message);
	    }
	 private void sendEmail(String email, String subject, String body) {
		 System.out.print("send email called ");
	        SimpleMailMessage message = new SimpleMailMessage();
			 System.out.println("send with my mail id called ");
	        message.setFrom("pranumore1234@gmail.com");
	        System.out.println("send with my mail id called "+email);
	        message.setTo(email);
	        message.setSubject(subject);
	        message.setText(body);
	        mailSender.send(message);
	        System.out.println("mail successfully send");
	    }
	 
	 @Override
	  public ResponseEntity<String> verifyEmail(String email, String code) {
	        // Get the verification code from the map
		 System.out.println("email : "+email+" verificationCode : "+code);
	        
	        if (verificationCodes.get(email).equals(code)) {
	            // Update the isEnable field to true
	        	System.out.println("verification code checked");
	            Users user = userRepository.findByEmail(email);
	            System.out.println("verification enable");
	            user.setVerificationEnabled(true);
	            
	            userRepository.save(user);

	            // Remove the verification code from the map
	            verificationCodes.remove(email);
	            System.out.println("verification sucessfull");
	            return ResponseEntity.ok().body("successfully verified");
	        } else {
	        	return ResponseEntity.badRequest().body("Error :couldent verify email");
	        }
	    }
	 
	  
}
