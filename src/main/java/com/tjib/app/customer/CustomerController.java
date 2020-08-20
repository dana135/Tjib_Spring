package com.tjib.app.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tjib.app.entities.Shipping;
import com.tjib.app.order.Order;

import java.util.List;

/*
 * Controller for customer requests
 * Handles requests related to customer and shipping that sent to the server and sends responses
 * Allows communication between the server and the client
 */

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
	
	@RequestMapping("/customers/{id}/orders")
	public List<Order> getOrderHistory(@PathVariable int id) {
		return service.getOrderHistory(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/customers")
	public void addCustomer (@RequestBody Customer customer) {
		service.addCustomer(customer);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/customerslist")
	public void addCustomers (@RequestBody List<Customer> customers) {
		service.addCustomers(customers);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/customers/{id}")
	public void updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
		service.updateCustomer(id, customer);
	}

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

}
