package com.student.management.system.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.management.system.entity.User;
import com.student.management.system.repository.User_Repository;
import com.student.management.system.service.UserService;

@Service
public class User_Service_impl implements UserService{

	@Autowired
	private User_Repository user_repo;
	@Override
	public User saveUser(User user) {
		return user_repo.save(user);
	}
	public User getById(int id)
	{
		return user_repo.findById(id).get();
	}
	@Override
	public User findByUsernameAndPassword(String username, String password) {
		return user_repo.findByUsernameAndPassword(username, password);
	}

}
