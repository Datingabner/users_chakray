package com.chakray.service;

import java.util.List;
import java.util.Optional;

import com.chakray.modelo.Address;

public interface IAddressService {
	
	Address saveAddress(Address address);
	
	Address updateAddress(Address address);
	
	Optional<Address> getAddressById(int id);
	
	void deleteAddress(int id);
	
	List<Address> getAllAddressesByUserId(int userId);

}
