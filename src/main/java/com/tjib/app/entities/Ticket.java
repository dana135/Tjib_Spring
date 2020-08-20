package com.tjib.app.entities;

import javax.persistence.*;

/*
 * Represents a single ticket to a specific event
 */

@Entity
@Table(name = "tbl_ticket")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String eventName;
	private String section;
	private int position;
	private int price;
	private String status; //available or unavailable (if sold)
	
	public Ticket() {} //empty constructor for jpa
	
	public Ticket(String event, String section, int position, int price) { //constructor
		this.eventName = event;
		this.section = section;
		this.position = position;
		this.price = price;
		this.status = "available";
	}

	//getters and setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getPosition() {
		return position;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}
