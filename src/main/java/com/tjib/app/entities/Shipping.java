package com.tjib.app.entities;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tjib.app.order.Order;

@Entity
@Table(name = "tbl_shipping")
@JsonIgnoreProperties("order")
public class Shipping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToOne(cascade = CascadeType.ALL)
	private Order order;
	private String firstName;
	private String lastName;
	private String creditCard;
	private int creditExpiration;
	@ElementCollection
	private List<Integer> ticketIds;
	
	public Shipping() {}
	
	public Shipping(String firstName, String lastName, String creditCard, int creditExpiration, List<Integer> ticketIds) {
		super();
		order = null;
		this.firstName = firstName;
		this.lastName = lastName;
		this.creditCard = creditCard;
		this.creditExpiration = creditExpiration;
		this.ticketIds = ticketIds;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public int getCreditExpiration() {
		return creditExpiration;
	}

	public void setCreditExpiration(int creditExpiration) {
		this.creditExpiration = creditExpiration;
	}

	public List<Integer> getTicketIds() {
		return ticketIds;
	}

	public void setTicketIds(List<Integer> ticketIds) {
		this.ticketIds = ticketIds;
	}
	

}
