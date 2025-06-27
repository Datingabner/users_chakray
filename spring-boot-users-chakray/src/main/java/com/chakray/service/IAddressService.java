package com.chakray.service;

import java.util.List;
import java.util.Optional;

import com.chakray.modelo.Address;
import com.chakray.modelo.User;

public interface IAddressService {
	
	Address saveAddress(Address address);
	
	Address updateAddress(Address address);
	
	Optional<Address> getAddressById(int id);
	
	void deleteAddress(int id);
	
	List<Address> getAllAddressesByRelated_user(User userId);

}
