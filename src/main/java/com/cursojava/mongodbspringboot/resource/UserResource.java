package com.cursojava.mongodbspringboot.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursojava.mongodbspringboot.domain.User;
import com.cursojava.mongodbspringboot.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService users;
	
	@GetMapping
	public ResponseEntity<List<User>>findAll(){
		
			List<User> list = users.findAll();
			
			return ResponseEntity.ok().body(list);
	}

}
