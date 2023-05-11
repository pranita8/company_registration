package com.example.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.company.entity.UserRole;
import com.example.company.entity.Users;

@Repository
public interface usersRepository extends JpaRepository <Users, Long> {

	void save(UserRole userRole);
	
}
