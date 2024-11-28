package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
	
	Category findByCategoryName(String categoryName);

}