package com.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.dto.ProductDto;
import com.test.dto.ProductResponseDto;
import com.test.entity.Category;
import com.test.entity.Product;
import com.test.globalexception.ResourceNotFoundexception;
import com.test.repository.ICategoryRepository;
import com.test.repository.IProductRespository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl  implements IProductService {
	
	
	private final ObjectMapper objectMapper;
	
	private final IProductRespository productRespository;
	
	private final ICategoryRepository categoryRepository;

	@Override
	public ProductDto createProduct(ProductDto productDto) {

		Product convertInEntity = objectMapper.convertValue(productDto, Product.class);
		Category category = categoryRepository.findByCategoryName(productDto.getCategoryName());
		convertInEntity.setCategory(category);
		Product saveentity = productRespository.save(convertInEntity);
		return objectMapper.convertValue(saveentity, ProductDto.class);
	}

	@Override
	public List<ProductResponseDto> getAllproduct() {

		List<Product> allData = productRespository.findAll();
		ArrayList<ProductResponseDto> listofDto = new ArrayList<ProductResponseDto>();
		if (allData != null) {
			for (Product product : allData) {
				ProductResponseDto convertInDto = objectMapper.convertValue(product, ProductResponseDto.class);
				listofDto.add(convertInDto);
			}
		}
		return listofDto;
	}

	@Override
	public ProductResponseDto getProductByProductId(long productId) {

		Product product = productRespository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundexception("id not found exception"+productId));
		return objectMapper.convertValue(product, ProductResponseDto.class);
	}

	@Override
	public ProductDto UpdateProductByProductId(ProductDto productDto, long productId) {

		Product orElseThrow = productRespository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundexception("id not found exception"+productId));
		  Product convertValue = objectMapper.convertValue(productDto,Product.class);
		  orElseThrow.setProductID(convertValue.getProductID());
		
			Product saveentity = productRespository.save(convertValue);
			return objectMapper.convertValue(saveentity, ProductDto.class);
		
	}

	@Override
	public void deleteProductByProductId(long productId) {

		productRespository.deleteById(productId);

	}

}

