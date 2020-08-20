package com.tjib.app.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Service for order requests
 * Implements the logic required to handle requests and updates the database
 * Allows communication between the controller and the repository
 */

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> getAllOrders() {
		List<Order> orderList = new ArrayList<>();
		List<Order> orders = new ArrayList<>();
		repository.findAll().forEach(orders::add);
		//reverse the orders to be presented from new to old
		for(int i = orders.size()-1; i >= 0; i--) orderList.add(orders.get(i));
		return orderList;
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
	
	public void deleteOrder(int id) {
		repository.deleteById(id);
	}
	
	public void deleteAllOrders() {
		repository.deleteAll();
	}

}