package com.cursojava.mongodbspringboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojava.mongodbspringboot.domain.User;
import com.cursojava.mongodbspringboot.dto.UserDTO;
import com.cursojava.mongodbspringboot.repositories.UserRepository;
import com.cursojava.mongodbspringboot.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User>findAll(){
		List<User>users= repository.findAll();
		
		return users;
	}
	public User findById(String id) {
		Optional<User>user= repository.findById(id);
		
		
		if(user==null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user.get();
		
	}
	public User insert(User user) {
		return repository.insert(user);
	}
	public User fromDTO(UserDTO userDTO) {
		User user= new User();
		user.setId(userDTO.getId());
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		
		return user;
		
	}
}
