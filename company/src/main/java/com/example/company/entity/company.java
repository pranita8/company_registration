package com.example.company.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "company")
public class company {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long companyId;
    private String companyName;
    private String phoneNumber;
    private String emailId;
  
    @OneToMany(cascade=CascadeType.ALL)
     @JoinColumn(name="company_id")
      private List<Users> users;
    
    private Boolean isDeleted;

}
