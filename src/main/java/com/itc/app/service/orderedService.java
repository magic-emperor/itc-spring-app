package com.itc.app.service;

import java.util.List;

import com.itc.app.Dto.orderdDto;

public interface orderedService {
	orderdDto createNewOrder(orderdDto OrderdDto);
	List<orderdDto> getAllOrders();
	orderdDto getOrderById(Long orderId);
	void deleteOrderById(Long orderId);
	List<orderdDto> getAllOrderByUserId(Long userId);
	void deleteByOrderTime(String orderedTime);
}
