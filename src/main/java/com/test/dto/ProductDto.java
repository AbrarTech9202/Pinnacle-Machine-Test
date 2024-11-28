package com.test.dto;

import com.test.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
	
    private long productID; 
 	
	private String name; 
	
	private String description;
	
	private double price; 
	
	private double salePrice;
	
	private String categoryName;
	
	private Category category;

	

	
	

}
