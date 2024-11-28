package com.test.service;

import java.util.List;

import com.test.dto.ProductDto;
import com.test.dto.ProductResponseDto;

public interface IProductService {
	
	public ProductDto createProduct(ProductDto productDto);
	
	public List<ProductResponseDto> getAllproduct();
	
	public ProductResponseDto getProductByProductId(long productId);
	
	public ProductDto UpdateProductByProductId(ProductDto productDto,long productId );
	
	public void deleteProductByProductId(long productId);

}