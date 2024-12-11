package com.itc.app.productServiceImplemets;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itc.app.Dto.NotificationDto;
import com.itc.app.Dto.orderdDto;
import com.itc.app.Mapper.orderedMapper;
import com.itc.app.Repository.orderedRepositories;
import com.itc.app.productEntity.orderedEntity;
import com.itc.app.service.orderedService;

import jakarta.transaction.Transactional;

@Service
public class orderedServiceImplemets implements orderedService{
	@Autowired
	public orderedRepositories OrderedRepositories;
    @Autowired
    private NotificationService notificationService;

	@Override
	public orderdDto createNewOrder(orderdDto OrderdDto) {
		// TODO Auto-generated method stub
		orderedEntity OrderedEntity = orderedMapper.mapToOderedEntity(OrderdDto);
		orderedEntity saveOrder = OrderedRepositories.save(OrderedEntity);
	    NotificationDto notification = new NotificationDto(
	            saveOrder.getOrderId(),
	            "New Order Placed",
	            "Order Details: " + saveOrder.toString()
	        );

	        // Use the existing notificationService to send the notification
	        notificationService.sendNotification(notification);
		return orderedMapper.mapToOrderDto(saveOrder);
	}

	@Override
	public List<orderdDto> getAllOrders() {
		// TODO Auto-generated method stub
		List<orderedEntity> getAllOrders = OrderedRepositories.findAll();
		return getAllOrders.stream().map(orderedMapper::mapToOrderDto).collect(Collectors.toList());
	}

	@Override
	public orderdDto getOrderById(Long orderId) {
		// TODO Auto-generated method stub
		orderedEntity getOrderById = OrderedRepositories.findById(orderId).orElse(null);
		return orderedMapper.mapToOrderDto(getOrderById);
	}

	@Override
	public void deleteOrderById(Long orderId) {
		// TODO Auto-generated method stub
		OrderedRepositories.findById(orderId).orElse(null);
		OrderedRepositories.deleteById(orderId);
	}

	@Override
	public List<orderdDto> getAllOrderByUserId(Long userId) {
	    List<orderedEntity> ordersByUserId = OrderedRepositories.findAllByUserId(userId);
	    return ordersByUserId.stream().map(orderedMapper::mapToOrderDto).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public void deleteByOrderTime(String orderedTime) {
		OrderedRepositories.deleteByOrderedTime(orderedTime);
	}



}
