package com.tjib.app.customer;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjib.app.entities.Shipping;
import com.tjib.app.entities.ShippingRepository;
import com.tjib.app.entities.Ticket;
import com.tjib.app.entities.TicketRepository;
import com.tjib.app.order.Order;
import com.tjib.app.order.OrderRepository;

/*
 * Service for customer requests
 * Implements the logic required to handle requests and updates the database
 * Allows communication between the controller and the repository
 */

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ShippingRepository shippingRepository;
	@Autowired
	private TicketRepository ticketRepository;
	
	public List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<>();
		repository.findAll().forEach(customers::add);
		return customers;
	}
	
	public Customer getCustomer(int id) {
		return repository.findById(id).get();
	}
	
	public Customer findCustomer(String email, String password) { //confirm customer by email and password
		Customer customer = repository.findByEmail(email);
		if(customer != null && customer.getPassword().equals(password)) return customer; //email exists and password is correct
		return null; //no such customer
	}
	
	public Customer findCustomerByEmail(String email) {
		Customer customer = repository.findByEmail(email);
		return customer;
	}
	
	public List<Order> getOrderHistory(int id) {
		List<Order> orderList = new ArrayList<>();
		List<Order> orders = new ArrayList<>();
		repository.findById(id).get().getOrderHistory().forEach(orders::add);
		//reverse the orders to be presented from new to old
		for(int i = orders.size()-1; i >= 0; i--) orderList.add(orders.get(i));
		return orderList;
	}
	
	public void addCustomer(Customer customer) {
		repository.save(customer);
	}
	
	public void addCustomers(List<Customer> customers) {
		for(Customer customer : customers)
			repository.save(customer);
	}
	
	public void updateCustomer(int id, Customer customer) {
		Customer c = repository.findById(id).get();
		//update only non-empty fields
		if(!customer.getUsername().equals("")) c.setUsername(customer.getUsername());
		if(!customer.getEmail().equals("")) c.setEmail(customer.getEmail());
		if(!customer.getPassword().equals("")) c.setPassword(customer.getPassword());
		repository.save(c);
	}
	
	public void checkout(int id, Shipping shipping) { //place an order for a customer
		Customer customer = repository.findById(id).get();
		Order order = new Order(); //create a new order
		Shipping shippingDetails = new Shipping(); //create new shipping details entity
		List<Ticket> tickets = new ArrayList<>(); //tickets to add to the order entity
		List<Integer> ticketIds = shipping.getTicketIds(); //get tickets' ids from shipping
		int price = 0; //order price
		
		for(Integer t : ticketIds) { //for each ticket mentioned in the shipping
			Ticket ticket = ticketRepository.findById(t).get();
			ticket.setStatus("unavailable"); //update status, ticket is sold
			tickets.add(ticket); //add ticket to order
			price += ticket.getPrice(); //update order price
			ticketRepository.save(ticket);
		}

		//set shipping details fields
		shippingDetails.setOrder(order);
		shippingDetails.setFirstName(shipping.getFirstName());
		shippingDetails.setLastName(shipping.getLastName());
		shippingDetails.setCreditCard(shipping.getCreditCard());
		shippingDetails.setCreditExpiration(shipping.getCreditExpiration());
	
		//set order fields
		order.setCustomer(repository.findById(id).get());
		order.setShippingDetails(shipping);
		order.setTickets(tickets);
		order.setPrice(price);
		Calendar calendar = Calendar.getInstance();
		order.setOrderTime(calendar.getTime());
		
		orderRepository.save(order);
		shippingRepository.save(shippingDetails);
		
		customer.addToOrderHistory(order); //add the order to the customer's order history
		repository.save(customer);
		
	}
	
	public void deleteCustomer(int id) {
		repository.deleteById(id);
	}
	
	public void deleteAllCustomers() {
		repository.deleteAll();
	}
	
	public void deleteAllShipping() {
		shippingRepository.deleteAll();
	}

}
