package com.student.management.system.service;

import com.student.management.system.entity.User;

public interface UserService {

	public User saveUser(User user);
	
	public User findByUsernameAndPassword(String username,String password);
	
	public User getById(int id );
}
