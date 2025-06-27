package com.chakray.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chakray.modelo.Address;
import com.chakray.modelo.User;
import com.chakray.service.AddressServiceImpl;
import com.chakray.service.UserServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RequestMapping({"/users"})
public class UserController {
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired 
	private AddressServiceImpl addressService;
	/**
	 * Controlador para manejar las operaciones relacionadas con los usuarios.
	 * 
	 * Este controlador puede ser utilizado para manejar las operaciones CRUD de usuarios y direcciones.
	 * 
	 * Los endpoints pueden incluir:
	 * - Obtener todos los usuarios
	 * - Obtener un usuario por ID
	 * - Crear un nuevo usuario
	 * - Actualizar un usuario existente
	 * - Eliminar un usuario
	 * - Manejar direcciones asociadas a los usuarios
	 *
	 * * Controlador para manejar las operaciones relacionadas con los usuarios.
	 * Aqui se pueden agregar endpoints para manejar las operaciones CRUD de usuarios y direcciones..
	 * 
	 */
	
	
	 @GetMapping
	    public List<User> getAllUsers(@RequestParam(required = false) String sortedBy) {
	        
	        // Validar y mapear el parámetro sortedBy al campo correspondiente
	        String sortField = "id"; // Valor por defecto
	        if (sortedBy != null && !sortedBy.isEmpty()) {
	            switch (sortedBy.toLowerCase()) {
	                case "email":
	                    sortField = "email";
	                    break;
	                case "name":
	                    sortField = "name";
	                    break;
	                case "created_at":
	                    sortField = "createdAt";
	                    break;
	                // id es el valor por defecto
	            }
	        }
	        
	        return userService.getAllUsersSorted(sortField);
	    }
	
	
	@GetMapping("/{id}/address")
	public List<Address> getAddressByIdUser(@PathVariable int id) {
		Optional<User> userId=null;
		userId=userService.getUserById(id);
		return addressService.getAllAddressesByRelated_user((User) userId.get());
	}
	
	@PutMapping("/{id}/addresses/{addressid}")
	public ResponseEntity<Address> putAddress(@PathVariable int id,
			@RequestBody Address address) {
		address.setId(id);
		if(address.getId() > 0 && addressService.getAddressById(id).isPresent()) {
			address = addressService.updateAddress(address);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/newuser")
	public ResponseEntity<User> postUser(@RequestBody User user) {		
		user = userService.saveUser(user);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<User> patchUser(@PathVariable int id, @RequestBody User user) {
		user.setId(id);
		if(user.getId() > 0 && userService.getUserById(id).isPresent()) {
			user = userService.updateUser(user);
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable int id) {
		if(userService.getUserById(id).isPresent()) {
			userService.deleteUser(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


}
