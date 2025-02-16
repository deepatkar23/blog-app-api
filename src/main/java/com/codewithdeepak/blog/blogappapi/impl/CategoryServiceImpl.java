package com.codewithdeepak.blog.blogappapi.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithdeepak.blog.blogappapi.entities.Category;
import com.codewithdeepak.blog.blogappapi.exceptions.ResourceNotFoundException;
import com.codewithdeepak.blog.blogappapi.payloads.CategoryDto;
import com.codewithdeepak.blog.blogappapi.repositories.CategoryRepo;
import com.codewithdeepak.blog.blogappapi.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
		Category category=this.dtoToCategory(categoryDto);
		Category  categorySaved=this.categoryRepo.save(category);
		return this.categoryToDto(categorySaved);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		
		Category cat =this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category", "category id", categoryId));
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category updatedCat=this.categoryRepo.save(cat);
		CategoryDto categoryDro1= this.categoryToDto(updatedCat);
		
		return categoryDro1;
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category cat =this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category", "category id", categoryId));
		this.categoryRepo.delete(cat);
		
		
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		Category cat =this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category", "category id", categoryId));
		
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategoris() {
		
		List<Category> categories=this.categoryRepo.findAll();
		List<CategoryDto> catDto1=categories.stream().map((cat)-> this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		return catDto1;
	}
	
	private Category dtoToCategory(CategoryDto categoryDto) {
		Category category=this.modelMapper.map(categoryDto, Category.class);
		return category;
	}
	
	private CategoryDto categoryToDto(Category category) {
		CategoryDto categoryDto=this.modelMapper.map(category, CategoryDto.class);
		return categoryDto;
	}

}
