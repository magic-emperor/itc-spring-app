package com.itc.app.Mapper;

import com.itc.app.Dto.productDto;
import com.itc.app.productEntity.productEntity;

public class productMapper {
	public static productDto mapToProductDto(productEntity ProductEntity) {
		return new productDto(
				ProductEntity.getProductId(),
				ProductEntity.getproductCategory(),
				ProductEntity.getProductName(),
				ProductEntity.getProductUnitPrice(),
				ProductEntity.getProductPrice(),
				ProductEntity.getProductURL(),
				ProductEntity.getProductQuantity(),
				ProductEntity.getProductDescription()
				);
	}
	
	public static productEntity mapToProductEntity(productDto ProductDto) {
		return new productEntity(
				ProductDto.getProductId(),
				ProductDto.getProductCategory(),
				ProductDto.getProductName(),
				ProductDto.getProductUnitPrice(),
				ProductDto.getProductPrice(),
				ProductDto.getProductURL(),
				ProductDto.getProductQuantity(),
				ProductDto.getProductDescription()
				);
		
	}
}
