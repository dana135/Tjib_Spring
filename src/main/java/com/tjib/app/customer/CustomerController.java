package com.tjib.app.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tjib.app.entities.Shipping;
import com.tjib.app.entities.Ticket;
import com.tjib.app.order.Order;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@RequestMapping("/customers")
	public List<Customer> getAllCustomers() {
		return service.getAllCustomers();
	}
	
	@RequestMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable int id) {
		return service.getCustomer(id);
	}
	
	@RequestMapping("/customers/login")
	public Customer login(@RequestParam String email, @RequestParam String password) {
		return service.findCustomer(email, password);
	}
	
	@RequestMapping("/customers/findemail")
	public Customer findCustomerByEmail(@RequestParam String email) {
		return service.findCustomerByEmail(email);
	}
	
	@RequestMapping("/customers/{id}/shippingdetails")
	public Shipping getShippingDetails(@PathVariable int id) {
		return service.getShippingDetails(id);
	}
	
	@RequestMapping("/customers/{id}/orders")
	public List<Order> getOrderHistory(@PathVariable int id) {
		return service.getOrderHistory(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/customers")
	public void addCustomer (@RequestBody Customer customer) {
		service.addCustomer(customer);
	}
	
	@RequestMapping(method=RequestMethod.PATCH, value="/customers/{id}")
	public void updateCustomer(@PathVariable int id, Customer customer) {
		service.updateCustomer(id, customer);
	}
	/*
	@RequestMapping(method=RequestMethod.PUT, value="/customers/{id}/checkout2")
	public void checkout2(@PathVariable int id, int ticketId, String firstName, String lastName, String country, 
			String city, String street, int houseNum, String zipCode, String creditCard, int creditExpiration) {
		service.checkout2(id, ticketId, firstName, lastName, country, city, street, houseNum, zipCode, creditCard, creditExpiration);
	}
	*/
	@RequestMapping(method=RequestMethod.PUT, value="/customers/{id}/checkout", consumes= {"application/json;charset=UTF-8"})
	public void checkout(@PathVariable int id, @RequestBody Shipping shipping) {
		service.checkout(id, shipping);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/customers/{id}")
	public void deleteCustomer(@PathVariable int id) {
		service.deleteCustomer(id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/customers")
	public void deleteAllCustomers() {
		service.deleteAllCustomers();
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE, value="/shipping")
	public void deleteAllShipping() {
		service.deleteAllShipping();
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/tickets")
	public void deleteAllTickets() {
		service.deleteAllTickets();
	}


}
