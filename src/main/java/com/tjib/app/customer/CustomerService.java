package com.tjib.app.customer;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.tjib.app.entities.Shipping;
import com.tjib.app.entities.ShippingRepository;
import com.tjib.app.entities.Ticket;
import com.tjib.app.entities.TicketRepository;
import com.tjib.app.entities.UnauthorizedException;
import com.tjib.app.order.Order;
import com.tjib.app.order.OrderRepository;

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
	
	public Customer findCustomer(String email, String password) {
		Customer customer = repository.findByEmail(email);
		if(customer != null && customer.getPassword().equals(password)) return customer;
		else throw new UnauthorizedException();
	}
	
	public Customer findCustomerByEmail(String email) {
		Customer customer = repository.findByEmail(email);
		if(customer != null) return customer;
		else throw new UnauthorizedException();
	}
	
	public Shipping getShippingDetails(int id) {
		return repository.findById(id).get().getShippingDetails();
	}
	
	public List<Order> getOrderHistory(int id) {
		return repository.findById(id).get().getOrderHistory();
	}
	
	public void addCustomer(Customer customer) {
		repository.save(customer);
	}
	
	public void updateCustomer(int id, Customer customer) {
		repository.save(customer);
	}
	
	public void checkout(int id, Shipping shipping) {
		Customer customer = repository.findById(id).get();
		Order order = new Order();
		Shipping shippingDetails = new Shipping();
		List<Ticket> tickets = new ArrayList<>();
		List<Integer> ticketIds = shipping.getTicketIds();
		System.out.println(shipping.getLastName());
		System.out.println(shipping.getTicketIds());
//		String [] ticketIds = shipping.getTicketIds().split(" ");
		int price = 0;
		
		for(Integer t : ticketIds) {
			Ticket ticket = ticketRepository.findById(t).get();
			ticket.setStatus("unavailable");
			tickets.add(ticket);
			price += ticket.getPrice();
			ticketRepository.save(ticket);
		}
		
		/*
		for(int i=0; i<ticketIds.length; i++) {
			Ticket ticket = ticketRepository.findById((Integer.valueOf(ticketIds[i]))).get();
			ticket.setStatus("unavailable");
			tickets.add(ticket);
			price += ticket.getPrice();
			ticketRepository.save(ticket);
		}
		*/
		shippingDetails.setOrder(order);
		shippingDetails.setFirstName(shipping.getFirstName());
		shippingDetails.setLastName(shipping.getLastName());
		shippingDetails.setCreditCard(shipping.getCreditCard());
		shippingDetails.setCreditExpiration(shipping.getCreditExpiration());
		
		order.setCustomer(repository.findById(id).get());
		order.setShippingDetails(shipping);
		order.setTickets(tickets);
		order.setPrice(price);
		Calendar calendar = Calendar.getInstance();
		order.setOrderTime(calendar.getTime());
		order.setStatus("completed");
		
		orderRepository.save(order);
		shippingRepository.save(shipping);
		
		customer.addToOrderHistory(order);
		repository.save(customer);
		
	}
	
	/*
	public void checkout2(int id, int ticketId, String firstName, String lastName, String country, 
			String city, String street, int houseNum, String zipCode, String creditCard, int creditExpiration) {
		Customer customer = repository.findById(id).get();
		Order order = new Order();
		Shipping shipping = new Shipping();
		Ticket tickets = ticketRepository.findById(ticketId).get();
		List<Ticket> ticks = new ArrayList<>();
		ticks.add(tickets);
		
		tickets.setStatus("unavailable");
		
		shipping.setOrder(order);
		shipping.setFirstName(firstName);
		shipping.setLastName(lastName);
		shipping.setCountry(country);
		shipping.setCity(city);
		shipping.setStreet(street);
		shipping.setHouseNum(houseNum);
		shipping.setZipCode(zipCode);
		shipping.setCreditCard(creditCard);
		shipping.setCreditExpiration(creditExpiration);
		
		order.setCustomer(repository.findById(id).get());
		order.setShippingDetails(shipping);
		order.setTickets(ticks);
		int price = 0;
		order.setPrice(price);
		Calendar calendar = Calendar.getInstance();
		order.setOrderTime(calendar.getTime());
		order.setStatus("completed");
		
		orderRepository.save(order);
		shippingRepository.save(shipping);
		
		customer.addToOrderHistory(order);
		repository.save(customer);
	}
	*/
	
	public void deleteCustomer(int id) {
		repository.deleteById(id);
	}
	
	public void deleteAllCustomers() {
		repository.deleteAll();
	}
	
	
	
	public void deleteAllShipping() {
		shippingRepository.deleteAll();
	}
	public void deleteAllTickets() {
		ticketRepository.deleteAll();
	}

}
