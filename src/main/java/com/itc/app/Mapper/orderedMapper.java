package com.itc.app.Mapper;

import com.itc.app.Dto.orderdDto;
import com.itc.app.productEntity.orderedEntity;

public class orderedMapper {
	
	public static orderdDto mapToOrderDto(orderedEntity OrderedEntity) {
		return new orderdDto(
				OrderedEntity.getOrderId(),
				OrderedEntity.getUserId(),
				OrderedEntity.getOrderedDate(),
				OrderedEntity.getOrderedTime(),
				OrderedEntity.getOrderedProductName(),
				OrderedEntity.getOrderedProductQuantity(),
				OrderedEntity.getOderedUserName(),
				OrderedEntity.getOrderedProductPrice(),
				OrderedEntity.getOrderdProductImageURL(),
				OrderedEntity.getOderedProductId(),
				OrderedEntity.getOrderedProductUnitPrice(),
				OrderedEntity.getOrderedUserNumber()
				);
	}
	
	public static orderedEntity mapToOderedEntity(orderdDto OrderdDto) {
		return new orderedEntity(
				OrderdDto.getOrderId(),
				OrderdDto.getUserId(),
				OrderdDto.getOrderedDate(),
				OrderdDto.getOrderedTime(),
				OrderdDto.getOrderedProductName(),
				OrderdDto.getOrderedProductQuantity(),
				OrderdDto.getOderedUserName(),
				OrderdDto.getOrderedProductPrice(),
				OrderdDto.getOrderdProductImageURL(),
				OrderdDto.getOderedProductId(),
				OrderdDto.getOrderedProductUnitPrice(),
				OrderdDto.getOrderedProductNumber()
				);
	}
}
