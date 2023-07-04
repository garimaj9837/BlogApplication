package com.blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
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

import com.blog.entities.Category;
import com.blog.payloads.ApiResponse;
import com.blog.payloads.CategoryDto;
import com.blog.services.CategoryService;

@RestController
@RequestMapping("api/category")
public class CategoryController {
		
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	ModelMapper modelMapper;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto ){
		CategoryDto createdCategory = categoryService.createCategory(categoryDto);
		return new ResponseEntity<>(createdCategory,HttpStatus.CREATED);
	}
	
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable ("categoryId") Integer Id){
		CategoryDto updatedCategory = categoryService.updateCategory(categoryDto, Id);
		return new ResponseEntity<>(updatedCategory,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategory(){
		List<CategoryDto> allCategories = categoryService.getAllCategory();
		return new ResponseEntity<>(allCategories,HttpStatus.OK);
	}
	
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable ("categoryId") Integer Id){
		CategoryDto category = categoryService.getCategory(Id);
		return new ResponseEntity<>(category,HttpStatus.OK);
	}
	
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<?> deleteCategory(@PathVariable ("categoryId") Integer Id){
		categoryService.deleteCategory(Id);
		return new ResponseEntity<>(new ApiResponse("User deleted successfully",true),HttpStatus.OK);
	}

}
