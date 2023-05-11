package com.example.company.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "company")
public class Company {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long companyId;
    private String companyName;
    private String phoneNumber;
    private String emailId;
    private String address;
    
//    @OneToMany(cascade=CascadeType.ALL)
//    @JoinColumn(name="company_id")
//    private List<Users> users;
//    
//    @OneToMany(cascade=CascadeType.ALL)
//    @JoinColumn(name="company_id")
//    private List<UserRole> role;
   
    private Boolean isDeleted;

}
