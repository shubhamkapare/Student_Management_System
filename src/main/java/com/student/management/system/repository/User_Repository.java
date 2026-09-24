package com.student.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.management.system.entity.User;

public interface User_Repository extends JpaRepository<User, Integer>{

	User findByUsernameAndPassword(String username,String password);

	//User findByUsernameAndPassword(String username, String password);
}
