package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) { //Return the type User object that is inside the Optional
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) { // Insert a new User
		return repository.save(obj);
	}
	
	public void delete(Long id) { // Delete a User
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) { // Update a user's data
			User entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
	}
	
	private void updateData(User entity, User obj) { // Search for data to update in the update function
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
