package com.test.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.dto.CategoryDto;
import com.test.service.ICategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {
	
	private final ICategoryService categoryService;
	
	
	@PostMapping("/create/categories") 
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto)
    {
	   return ResponseEntity.ok(categoryService.createCategory(categoryDto));
    }
	
	
	@GetMapping("/find/all-categories")
	public ResponseEntity<List<CategoryDto>> getAllCategory()
	{
		 return ResponseEntity.ok(categoryService.getAllCategory());
	}
	
	@GetMapping("/get/categories/{categoryId}")
	public ResponseEntity<CategoryDto> getCategoryBycategoryId(@PathVariable long categoryId)
	{
		 return ResponseEntity.ok(categoryService.getCategoryBycategoryId(categoryId));
	}
	
	@PutMapping("/update/categories/{categoryId}")
	public ResponseEntity<CategoryDto> UpdateCategoryBycategoryId(@RequestBody CategoryDto categoryDto,@PathVariable long categoryId )
	{
		 return ResponseEntity.ok(categoryService.UpdateCategoryBycategoryId(categoryDto, categoryId));
				 
	}
	
	@DeleteMapping("/delete/categories/{categoryId}")
	public String deleteCategoryBycategoryId(@PathVariable long categoryId)
	{
		categoryService.deleteCategoryBycategoryId(categoryId);
		return "category deleted successfully...";
	}
	
	

}
