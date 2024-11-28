package com.test.service;

import java.util.List;

import com.test.dto.CategoryDto;

public interface ICategoryService {
	
	
	public CategoryDto createCategory(CategoryDto categoryDto);
	
	public List<CategoryDto> getAllCategory();
	
	public CategoryDto getCategoryBycategoryId(long categoryId);
	
	public CategoryDto UpdateCategoryBycategoryId(CategoryDto categoryDto,long categoryId );
	
	public void deleteCategoryBycategoryId(long categoryId);

}

