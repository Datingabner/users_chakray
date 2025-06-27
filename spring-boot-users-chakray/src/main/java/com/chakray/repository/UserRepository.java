package com.chakray.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chakray.modelo.User;

public interface UserRepository extends CrudRepository<User, Integer> {
		List<User> findByEmail(String email);
	List<User> findByName(String name);
	List<User> findByCreatedAt(String createdAt);

}
