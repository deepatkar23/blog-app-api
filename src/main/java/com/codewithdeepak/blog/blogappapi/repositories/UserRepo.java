package com.codewithdeepak.blog.blogappapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithdeepak.blog.blogappapi.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	

}
