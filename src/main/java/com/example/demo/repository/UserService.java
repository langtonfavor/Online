package com.example.demo.repository;

import com.example.demo.Modal.User;

public interface UserService {

	public User findByEmail(String email);
	
	
	public void saveUser(User user);
}
