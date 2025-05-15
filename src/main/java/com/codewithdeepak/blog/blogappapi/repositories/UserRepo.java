package com.codewithdeepak.blog.blogappapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithdeepak.blog.blogappapi.entities.Category;
import com.codewithdeepak.blog.blogappapi.entities.Post;
import com.codewithdeepak.blog.blogappapi.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	

}
