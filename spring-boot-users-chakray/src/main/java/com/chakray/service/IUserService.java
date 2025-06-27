package com.chakray.service;

import java.util.List;
import java.util.Optional;

import com.chakray.modelo.User;

public interface IUserService {

	List<User> getAllUsers();
	
	List<User> getAllUsersByEmail(String email);
	
	List<User> getAllUsersByName(String name);
	
	List<User> getAllUsersByCreatedAt(String createdAt);
	
	Optional<User> getUserById(int id);
	
	User saveUser(User user);
	
	User updateUser(User user);
	
	void deleteUser(int id);
	
}
