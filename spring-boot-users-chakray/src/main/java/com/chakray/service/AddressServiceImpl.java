package com.chakray.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chakray.modelo.Address;
import com.chakray.modelo.User;
import com.chakray.repository.AddressRepository;

@Service
public class AddressServiceImpl implements IAddressService{
	
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Address saveAddress(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public Address updateAddress(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public Optional<Address> getAddressById(int id) {
		return addressRepository.findById(id);
	}

	@Override
	public void deleteAddress(int id) {
		addressRepository.deleteById(id);		
	}

	@Override
	public List<Address> getAllAddressesByRelated_user(User userId) {
		return addressRepository.findByRelatedUser(userId);
	}

}
