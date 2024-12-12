package com.itc.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itc.app.Dto.orderdDto;
import com.itc.app.service.orderedService;

@RestController
@RequestMapping("/api/order")
@CrossOrigin({ "https://itc-order-app.onrender.com", "**" })
public class orderedController {

	@Autowired
	public orderedService OrderedService;

	@CrossOrigin(origins = "https://itc-order-app.onrender.com")
	@PostMapping
	public ResponseEntity<?> createNewOrder(@RequestBody orderdDto OrderdDto) {
		orderdDto createNewOrder = OrderedService.createNewOrder(OrderdDto);
		return new ResponseEntity<>(createNewOrder, HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "https://itc-order-app.onrender.com")
	@GetMapping
	public ResponseEntity<?> getAllOrders() {
		List<orderdDto> getAllOrders = OrderedService.getAllOrders();
		return ResponseEntity.ok(getAllOrders);
	}

	@GetMapping("byuser/{id}")
	public ResponseEntity<?> getAllOrdersByUserId(@PathVariable("id") Long userId) {
		List<orderdDto> getOrdersUserId = OrderedService.getAllOrderByUserId(userId);
		return ResponseEntity.ok(getOrdersUserId);
	}

	@CrossOrigin(origins = "https://itc-order-app.onrender.com")
	@GetMapping("{id}")
	public ResponseEntity<?> getOrderById(@PathVariable("id") Long orderId) {
		orderdDto getOrderById = OrderedService.getOrderById(orderId);
		return ResponseEntity.ok(getOrderById);
	}

	@CrossOrigin(origins = "https://itc-order-app.onrender.com")
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") Long orderId) {
		OrderedService.deleteOrderById(orderId);
		return ResponseEntity.ok("Order Deleted Successfully " + orderId);
	}

	@DeleteMapping("deletebytime/{orderedTime}")
	public ResponseEntity<String> deletebytime(@PathVariable String orderedTime) {
		OrderedService.deleteByOrderTime(orderedTime);
		return ResponseEntity.ok("Order Deleted Successfully " + orderedTime);
	}
}
