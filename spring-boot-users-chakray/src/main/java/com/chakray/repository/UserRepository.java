package com.chakray.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chakray.modelo.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>, CrudRepository<User, Integer> {
		List<User> findByEmail(String email);
	List<User> findByName(String name);

}
