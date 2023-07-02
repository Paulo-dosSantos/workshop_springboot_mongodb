package com.cursojava.mongodbspringboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojava.mongodbspringboot.domain.User;
import com.cursojava.mongodbspringboot.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User>findAll(){
		List<User>users= repository.findAll();
		
		return users;
	}

}
