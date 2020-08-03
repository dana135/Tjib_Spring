package com.tjib.app.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjib.app.entities.Ticket;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> getAllOrders() {
		List<Order> orders = new ArrayList<>();
		repository.findAll().forEach(orders::add);
		return orders;
	}
	
	public Order getOrder(int id) {
		return repository.findById(id).get();
	}
	
	public void addOrder(Order order) {
		repository.save(order);
	}
	
	public void updateOrder(int id, Order order) {
		repository.save(order);
	}
	
	public void returnOrder(int id) {
		Order order = repository.findById(id).get();
		order.setStatus("refunded");
		repository.save(order);
	}
	
	public void addTicket(int id, Ticket ticket) {
		Order order = repository.findById(id).get();
		order.addTicket(ticket);
		repository.save(order);
	}
	
	public void deleteOrder(int id) {
		repository.deleteById(id);
	}
	
	public void deleteAllOrders() {
		repository.deleteAll();
	}

}