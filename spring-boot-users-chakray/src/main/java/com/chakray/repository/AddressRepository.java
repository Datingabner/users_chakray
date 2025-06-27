package com.chakray.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chakray.modelo.Address;

public interface AddressRepository  extends CrudRepository<Address, Integer> {
	// Aquí puedes definir métodos específicos para manejar direcciones
	// Por ejemplo, encontrar direcciones por usuario, ciudad, etc.
	// List<Address> findByUserId(int userId);
	// List<Address> findByCity(String city);
	
	List<Address> findByUserId(int userId);
	

}
