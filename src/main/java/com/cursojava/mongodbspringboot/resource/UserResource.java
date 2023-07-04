package com.cursojava.mongodbspringboot.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	@GetMapping(value="/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		User user= users.findById(id);
		UserDTO userDTO= new UserDTO(user);
		
		return ResponseEntity.ok().body(userDTO);
		
	}
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO){
		User obj= users.fromDTO(userDTO);
		users.insert(obj);
		URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void>delete(@PathVariable String id){
		users.delete(id);
		
		return ResponseEntity.noContent().build();
		
	}
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update( @RequestBody UserDTO obj,@PathVariable String id){
		User user= users.fromDTO(obj);
		user.setId(id);
		user=users.update( user);
		
		return ResponseEntity.noContent().build();
		
		
	}
}
