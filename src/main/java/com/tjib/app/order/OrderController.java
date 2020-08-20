package com.tjib.app.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Controller for order requests
 * Handles requests related to order that sent to the server and sends responses
 * Allows communication between the server and the client
 */

@RestController
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@RequestMapping("/orders")
	public List<Order> getAllOrders() {
		return service.getAllOrders();
	}
	
	@RequestMapping("/orders/{id}")
	public Order getOrder(@PathVariable int id) {
		return service.getOrder(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/orders")
	public void addOrder (Order order) {
		service.addOrder(order);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/orders/{id}")
	public void updateOrder(@PathVariable int id, Order order) {
		service.updateOrder(id, order);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/orders/{id}")
	public void deleteOrder(@PathVariable int id) {
		service.deleteOrder(id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/orders")
	public void deleteAllOrders() {
		service.deleteAllOrders();
	}


}
