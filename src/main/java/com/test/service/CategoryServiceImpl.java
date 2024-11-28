package com.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.dto.CategoryDto;
import com.test.entity.Category;
import com.test.globalexception.ResourceNotFoundexception;
import com.test.repository.ICategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {
	
	private final ICategoryRepository categoryRepository;
	
	private final ObjectMapper objectMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		 Category convertValue = objectMapper.convertValue(categoryDto, Category.class);
		Category saveentity = categoryRepository.save(convertValue);
		return objectMapper.convertValue(saveentity, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> allenttyData = categoryRepository.findAll();
		ArrayList<CategoryDto> listofDtoCategory = new ArrayList<CategoryDto>();
		if(allenttyData != null)
		{
			for(Category category : allenttyData)
			{
				CategoryDto convertInDto = objectMapper.convertValue(category, CategoryDto.class);
				listofDtoCategory.add(convertInDto);	
			}
		}
		return listofDtoCategory;
	}

	@Override
	public CategoryDto getCategoryBycategoryId(long categoryId) {
		Category categoryEntity = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundexception("id not found exception"+categoryId));
		return objectMapper.convertValue(categoryEntity, CategoryDto.class);

	}

	@Override
	public CategoryDto UpdateCategoryBycategoryId(CategoryDto categoryDto, long categoryId) {
		Category categoryEntity = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundexception("id not found exception"+categoryId));
		Category convertValue = objectMapper.convertValue(categoryDto, Category.class);
		          categoryEntity.setCategoryId(convertValue.getCategoryId());
		
		          Category saveEntity = categoryRepository.save(convertValue);
			return objectMapper.convertValue(saveEntity, CategoryDto.class);
		
	}

	@Override
	public void deleteCategoryBycategoryId(long categoryId) {
		categoryRepository.deleteById(categoryId);
		
	}

	
	
	

}

