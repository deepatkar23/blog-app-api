package com.codewithdeepak.blog.blogappapi.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

	
	private Integer categoryId;
	
	
	private String categoryTitle;
	
	
	private String categoryDescription;
	
}
