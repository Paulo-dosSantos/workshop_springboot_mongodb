package com.cursojava.mongodbspringboot.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cursojava.mongodbspringboot.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}
