package com.itc.app.service;

import java.util.List;

import com.itc.app.Dto.productDto;

public interface productService{
	productDto createNewProduct(productDto ProductDto);
	productDto getProductById(Long ProductId);
	List<productDto> getAllProduct();
}
