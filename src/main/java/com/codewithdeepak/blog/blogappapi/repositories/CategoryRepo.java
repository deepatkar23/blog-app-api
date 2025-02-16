package com.codewithdeepak.blog.blogappapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithdeepak.blog.blogappapi.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
