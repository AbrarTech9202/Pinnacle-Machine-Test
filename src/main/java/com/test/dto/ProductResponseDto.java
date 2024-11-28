package com.test.dto;



import com.test.entity.Category;

import lombok.Data;

@Data
public class ProductResponseDto {
	
	    private long productID; 
	 	
		private String name; 
		
		private String description;
		
		private double price; 
		
		private double salePrice;
		
		private Category category;


}
