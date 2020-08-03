package com.tjib.app.event;

import java.util.ArrayList;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tjib.app.entities.Ticket;
import com.tjib.app.venue.Venue;

import java.util.List;

@Entity
@Table(name = "tbl_event")
@JsonIgnoreProperties({"tickets", "venue"})
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	// live concert / online concert / fan meeting
	private String eventType;
	/* yyyy/mm/dd/sh/eh */
	private int[] dateAndTime;
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "venue_id")
	@JsonIgnoreProperties("events")
	private Venue venue;
	@OneToMany(mappedBy = "event", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true)
	@JsonIgnoreProperties("event")
	private List<Ticket> tickets;
	private String image;
	
	public Event() {}
	
	public Event(String name, String eventType,  int[] dateAndTime, Venue venue, String image) {
		this.name = name;
		this.eventType= eventType;
		this.dateAndTime = dateAndTime;
		this.venue = venue;
		this.tickets = new ArrayList<Ticket>();
		this.image = image;
	}
	
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

	public int[] getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(int[] dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	
	public String getVenueName() {
		return venue.getVenueName();
	}

	public List<Ticket> getTickets () {
		return tickets;
	}
	
	public void setTickets(ArrayList<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	public List<Ticket> availableTickets() {
		List<Ticket> availableTickets = new ArrayList<Ticket>();
		for(Ticket t : tickets) {
			if(t.getStatus().equals("available")) availableTickets.add(t);
		}
		return availableTickets;
	}
	
	public void addTicket(Ticket ticket) {
		this.tickets.add(ticket);
	}
	
	public void sellTicket(Ticket ticket) {
		for(int i=0; i<tickets.size(); i++) {
			if(tickets.get(i).equals(ticket)) {
				tickets.get(i).setStatus("unavailable");
				break;
			}
		}
	}
	
	/*
	 * public void returnTicket(Ticket ticket) { for(int i=0; i<tickets.size(); i++)
	 * { if(tickets.get(i).equals(ticket)) { tickets.get(i).setStatus("available");
	 * break; } } }
	 */
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	

}