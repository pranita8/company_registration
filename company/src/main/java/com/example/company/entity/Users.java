package com.example.company.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class Users {

	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
	private boolean isDeleted;
    
    @OneToOne //users-many & roleid-one
    @JoinColumn(name="role_id")
    private UserRole role;

    public String getEmail() {
		return email;
	}

    public String getPassword() {
		return password;
	}
    
	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//	    String usePassword = encoder.encode(password);
		this.password = password; 
	}
    
}
