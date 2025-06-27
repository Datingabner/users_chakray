package com.chakray.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chakray.modelo.Address;
import com.chakray.modelo.User;

@Repository
public interface AddressRepository  extends CrudRepository<Address, Integer> {	
	List<Address> findByRelatedUser(User related_user);
	

}
