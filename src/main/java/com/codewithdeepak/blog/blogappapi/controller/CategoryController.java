package com.codewithdeepak.blog.blogappapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithdeepak.blog.blogappapi.payloads.ApiTResponse;
import com.codewithdeepak.blog.blogappapi.payloads.CategoryDto;
import com.codewithdeepak.blog.blogappapi.services.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

@Autowired
CategoryService catservice;

@PostMapping("/")
public ResponseEntity<CategoryDto> craeteCategory(@RequestBody CategoryDto categoryDto){
	
	CategoryDto categoryDto1=this.catservice.createCategory(categoryDto);
	
	return new ResponseEntity<>(categoryDto1, HttpStatus.CREATED);
}

@PutMapping("/{categoryId}")
public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,@PathVariable Integer categoryId){
	CategoryDto categoryDto1 = this.catservice.updateCategory(categoryDto, categoryId);
	return ResponseEntity.ok(categoryDto1);
}

@DeleteMapping("/{categoryId}")
public ResponseEntity<ApiTResponse> deleteUser(@PathVariable Integer categoryId){
	this.catservice.deleteCategory(categoryId);
	return  new ResponseEntity<ApiTResponse>(new ApiTResponse("Category deleted successfully", true),HttpStatus.OK);
}

@GetMapping("/{categoryId}")
public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer categoryId){
	CategoryDto categoryDto1 =this.catservice.getCategory(categoryId);
	return new ResponseEntity<>(categoryDto1, HttpStatus.OK);
}

@GetMapping("/")
public ResponseEntity<List<CategoryDto>> getCategories(){
	List<CategoryDto> categories =this.catservice.getCategoris();
	return ResponseEntity.ok(categories);
}
}
