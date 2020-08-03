package com.tjib.app.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tjib.app.entities.Ticket;

import java.util.List;

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
	
	@RequestMapping(method=RequestMethod.PUT, value="/orders/{id}/return")
	public void returnOrder(@PathVariable int id) {
		service.returnOrder(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/orders/{id}/addticket")
	public void addTicket(@PathVariable int id, Ticket ticket) {
		service.addTicket(id, ticket);
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
