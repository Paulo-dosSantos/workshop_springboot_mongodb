package com.cursojava.mongodbspringboot.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursojava.mongodbspringboot.domain.User;
import com.cursojava.mongodbspringboot.dto.UserDTO;
import com.cursojava.mongodbspringboot.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService users;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>>findAll(){
		
			List<User> list = users.findAll();
			List<UserDTO>listDTO= list.stream().map(x->new UserDTO(x)).collect(Collectors.toList());
			
			return ResponseEntity.ok().body(listDTO);
	}

}
