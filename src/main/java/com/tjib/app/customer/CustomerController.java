package com.tjib.app.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tjib.app.entities.Shipping;
import com.tjib.app.entities.Ticket;

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
	
	@RequestMapping(method=RequestMethod.POST, value="/customers")
	public void addCustomer (Customer customer) {
		service.addCustomer(customer);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/customers/{id}")
	public void updateCustomer(@PathVariable int id, Customer customer) {
		service.updateCustomer(id, customer);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/customers/{id}/setshipping")
	public void setShipping(@PathVariable int id, Shipping shipping) {
		service.setShipping(id, shipping);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/customers/{id}/checkout")
	public void checkout(@PathVariable int id, List<Ticket> tickets) {
		service.checkout(id, tickets);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/customers/{id}")
	public void deleteCustomer(@PathVariable int id) {
		service.deleteCustomer(id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/customers")
	public void deleteAllCustomers() {
		service.deleteAllCustomers();
	}


}
