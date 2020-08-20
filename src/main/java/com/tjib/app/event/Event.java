package com.tjib.app.event;

import java.util.ArrayList;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tjib.app.entities.Ticket;

import java.util.List;

/*
 * Represents an event with tickets for sale
 */

@Entity
@Table(name = "tbl_event")
@JsonIgnoreProperties({"tickets"})
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String eventType; // live concert / online concert / fan meeting
	private String dateAndTime;
	private String venueName;
	@ElementCollection
	private List<Ticket> tickets;
	private String image;
	
	public Event() {} //empty constructor for jpa
	
	public Event(String name, String eventType, String dateAndTime, String venueName, String image) { //constructor
		this.name = name;
		this.eventType= eventType;
		this.dateAndTime = dateAndTime;
		this.venueName = venueName;
		this.tickets = new ArrayList<Ticket>();
		this.image = image;
	}
	
	//getters and setters
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	
	public String getEventType() {
		return eventType;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public List<Ticket> getTickets () {
		return tickets;
	}
	
	public void setTickets(ArrayList<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	public void addTicket(Ticket ticket) { //add a ticket for sale for this event
		this.tickets.add(ticket);
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	

}