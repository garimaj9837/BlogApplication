package com.blog.services;

import java.util.List;

import com.blog.payloads.CategoryDto;

public interface CategoryService {

	 CategoryDto createCategory(CategoryDto categoryDto);
	 CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	 void deleteCategory(Integer categoryId);
	 List<CategoryDto> getAllCategory();
	 CategoryDto getCategory(Integer categoryId);




}
