package com.itc.app.productServiceImplemets;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itc.app.Dto.productDto;
import com.itc.app.Mapper.productMapper;
import com.itc.app.Repository.productRepositories;
import com.itc.app.productEntity.productEntity;
import com.itc.app.service.productService;

@Service
public class productServiceImplements implements productService{
	@Autowired
	public productRepositories ProductRepositories;
	
	@Override
	public productDto createNewProduct(productDto ProductDto) {
		// TODO Auto-generated method stub
		productEntity ProductEntity = productMapper.mapToProductEntity(ProductDto);
		productEntity saveNewProduct = ProductRepositories.save(ProductEntity);
		return productMapper.mapToProductDto(saveNewProduct);
	}

	public productDto getProductById(Long ProductId) {
		// TODO Auto-generated method stub
		productEntity ProductEntity = ProductRepositories.findById(ProductId).orElse(null);
		return productMapper.mapToProductDto(ProductEntity);
	}

	@Override
	public List<productDto> getAllProduct() {
		// TODO Auto-generated method stub
		List<productEntity> ProductEntity =  ProductRepositories.findAll();
		return ProductEntity.stream().map(productMapper::mapToProductDto).collect(Collectors.toList());
	}

}
