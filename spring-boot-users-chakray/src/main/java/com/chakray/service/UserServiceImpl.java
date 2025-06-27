package com.chakray.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chakray.modelo.User;
import com.chakray.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService{
		// Aquí se implementarán los métodos definidos en la interfaz UserService
	// Por ejemplo, obtenerTodosLosUsuarios(), obtenerUsuarioPorId(), etc.
	
	// Este es un ejemplo de implementación de un método
	// public List<User> obtenerTodosLosUsuarios() {
	//     // Lógica para obtener todos los usuarios
	// }
	
	// Otros métodos seguirán el mismo patrón

	// Puedes inyectar repositorios o servicios adicionales según sea necesario

	@Autowired
	private UserRepository userRepository;

		@Override
		public List<User> getAllUsers() {
			return (List<User>) userRepository.findAll();
		}

		@Override
		public List<User> getAllUsersByEmail(String email) {
			return userRepository.findByEmail(email);
		}

		@Override
		public List<User> getAllUsersByName(String name) {
			return userRepository.findByName(name);
		}

		

		@Override
		public Optional<User> getUserById(int id) {
			return userRepository.findById(id);
		}

		@Override
		public User saveUser(User user) {
			return userRepository.save(user);
		}

		@Override
		public User updateUser(User user) {
			return userRepository.save(user);
		}

		@Override
		public void deleteUser(int id) {
			userRepository.deleteById(id);
		}

	
	// Aquí puedes implementar los métodos de la interfaz UserService
}
