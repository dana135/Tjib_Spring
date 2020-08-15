package com.tjib.app.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tjib.app.event.Event;
import com.tjib.app.order.Order;

@Entity
@Table(name = "tbl_ticket")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
//	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH})
//	@JoinColumn(name = "event_id")
//	@JsonIgnoreProperties("tickets")
//	private Event event;
	private String eventName;
	private String section;
	//0 if unmarked
	private int position;
	private int price;
	private String status;
	
	public Ticket() {}
	
	public Ticket(int num, String event, String section, int position, int price) {
		this.position = num;
		this.eventName = event;
		this.section = section;
		this.position = position;
		this.price = price;
		this.status = "available";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*
	 * public Event getEvent() { return event; }
	 * 
	 * public void setEvent(Event event) { this.event = event; }
	 */

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
