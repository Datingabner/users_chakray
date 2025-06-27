package com.chakray.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chakray.modelo.User;
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
		List<User> findByEmail(String email);
	List<User> findByName(String name);

}
