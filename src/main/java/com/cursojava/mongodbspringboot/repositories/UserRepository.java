package com.cursojava.mongodbspringboot.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cursojava.mongodbspringboot.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
