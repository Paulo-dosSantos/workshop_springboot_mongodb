package com.cursojava.mongodbspringboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojava.mongodbspringboot.domain.Post;
import com.cursojava.mongodbspringboot.repositories.PostRepository;
import com.cursojava.mongodbspringboot.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	
	public Post findById(String id) {
		Optional<Post>post= repository.findById(id);
		
		
		if(post==null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return post.get();
		
	}
	
}
