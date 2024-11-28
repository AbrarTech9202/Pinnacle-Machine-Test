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

import com.test.dto.ProductDto;
import com.test.dto.ProductResponseDto;
import com.test.service.IProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {
	
	private final IProductService productService;
	
	
	@PostMapping("/create/product")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto)
    {
		return ResponseEntity.ok(productService.createProduct(productDto));
    }
	
	@GetMapping("/get/all-product")
	public ResponseEntity<List<?>> getAllproduct()
	{
		return ResponseEntity.ok(productService.getAllproduct());
	}
	
	@GetMapping("/getProduct/ByProductId/{productId}")
	public ResponseEntity<ProductResponseDto> getProductByProductId(@PathVariable long productId)
	{
		return ResponseEntity.ok(productService.getProductByProductId(productId));
	}
	
	@PutMapping("/update/product/{productId}")
	public ResponseEntity<ProductDto> UpdateProductByProductId(@RequestBody ProductDto productDto,@PathVariable long productId )
	{
		return ResponseEntity.ok(productService.UpdateProductByProductId(productDto, productId));
	}
	
	@DeleteMapping("/delete/product/{productId}")
	public String deleteProductByProductId(@PathVariable long productId)
	{
		productService.deleteProductByProductId(productId);
		return "product deleted successfully...";
	}

}