package com.example.company.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class Users {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String firstName;
    private String lastName;
    
    @Column(name="MAIL_ID", unique=true)
    private String email;
    private String password;
    private boolean verificationEnabled;
    
//	@OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="role_id")
//    private UserRole role;
//	
	 private boolean isDeleted;
}
