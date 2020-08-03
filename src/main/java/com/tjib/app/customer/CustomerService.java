package com.tjib.app.customer;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjib.app.entities.Shipping;
import com.tjib.app.entities.Ticket;
import com.tjib.app.order.Order;
import com.tjib.app.order.OrderRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	@Autowired
	private OrderRepository orderRepository;
	
	public List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<>();
		repository.findAll().forEach(customers::add);
		return customers;
	}
	
	public Customer getCustomer(int id) {
		return repository.findById(id).get();
	}
	
	public void addCustomer(Customer customer) {
		repository.save(customer);
	}
	
	public void updateCustomer(int id, Customer customer) {
		repository.save(customer);
	}
	
	public void setShipping(int id, Shipping shipping) {
		Customer customer = repository.findById(id).get();
		customer.setShippingDetails(shipping);
		repository.save(customer);
	}
	
	public void checkout(int id, List<Ticket> tickets) {
		Customer customer = repository.findById(id).get();
		Order order = new Order();
		
		order.setCustomer(repository.findById(id).get());
		order.setShipping(repository.findById(id).get().getShippingDetails());
		order.setTickets(tickets);
		int price = 0;
		for(Ticket t : tickets) price += t.getPrice();
		order.setPrice(price);
		Calendar calendar = Calendar.getInstance();
		order.setOrderTime(calendar.getTime());
		order.setStatus("completed");
		orderRepository.save(order);
		
		customer.addToOrderHistory(order);
		repository.save(customer);
	}
	
	public void deleteCustomer(int id) {
		repository.deleteById(id);
	}
	
	public void deleteAllCustomers() {
		repository.deleteAll();
	}

}
