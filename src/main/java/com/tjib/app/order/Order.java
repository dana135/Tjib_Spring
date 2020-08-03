package com.tjib.app.order;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tjib.app.customer.Customer;
import com.tjib.app.entities.Shipping;
import com.tjib.app.entities.Ticket;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_order")
@JsonIgnoreProperties("customer")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderNum;
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "customer_id")
	private Customer customer;
	@ManyToOne
	private Shipping shippingDetails;
	@ElementCollection 
	private List<Ticket> tickets;
	private int price;
	//yy/mm/dd/hr
	private Date orderTime;
	private String status;
	
	public Order() {}

	public Order(int orderNum, Customer customer, Shipping shippingDetails, List<Ticket> tickets, int price,
			Date orderTime, String status) {
		super();
		this.orderNum = orderNum;
		this.customer = customer;
		this.shippingDetails = shippingDetails;
		this.tickets = tickets;
		this.price = price;
		this.orderTime = orderTime;
		this.status = status;
	}

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
	
	
	public Shipping getShipping() {
		return shippingDetails;
	}

	public void setShipping(Shipping shippingDetails) {
		this.shippingDetails = shippingDetails;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	public void initTickets() {
		this.tickets = new ArrayList<Ticket>();
	}
	
	public void addTicket(Ticket ticket) {
		this.tickets.add(ticket);
		for(Ticket t : tickets) t.getEvent().sellTicket(t);
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

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	
}
