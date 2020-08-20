package com.tjib.app.order;

import javax.persistence.*;

import com.tjib.app.customer.Customer;
import com.tjib.app.entities.Shipping;
import com.tjib.app.entities.Ticket;

import java.util.Date;
import java.util.List;

/*
 * Represents a single order that a specific customer placed
 * May contain multiple tickets
 */

@Entity
@Table(name = "tbl_order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderNum;
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "customer_id")
	private Customer customer;
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Shipping shippingDetails;
	@OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Ticket> tickets;
	private int price;
	private Date orderTime;
	
	public Order() {} //empty constructor for jpa

	public Order(Customer customer, Shipping shippingDetails, List<Ticket> tickets, int price, Date orderTime) { //constructor
		this.customer = customer;
		this.shippingDetails = shippingDetails;
		this.tickets = tickets;
		this.price = price;
		this.orderTime = orderTime;
	}

	//getters and setters
	
	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	public Shipping getShippingDetails() {
		return shippingDetails;
	}

	public void setShippingDetails(Shipping shippingDetails) {
		this.shippingDetails = shippingDetails;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public void addTicket(Ticket ticket) { //add a ticket to this order
		this.tickets.add(ticket);
		this.price += ticket.getPrice();
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	
}
