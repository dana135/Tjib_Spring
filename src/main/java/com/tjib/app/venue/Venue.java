package com.tjib.app.venue;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tjib.app.event.Event;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_venue")
public class Venue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String venueName;
	
	//[0]seats type  [1]number of seats
//	@ElementCollection 
//	private List<String[]> seats;
	
	private String location;
	private int capacity;
	
	
//	@OneToMany(mappedBy = "venueName", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true)
//	@JsonIgnoreProperties("venue")
//	private List<Event> events;

	
	public Venue() {};
	
	public Venue(String venueName, String location, int capacity) {
		this.venueName = venueName;
	//	this.seats = seats;
		this.location = location;
		this.capacity = capacity;
	//	this.seats = new ArrayList<>();
	//	if(seats != null) addBulkSeats(seats);
	}
	
	public int getId() {
		return id;
	}
	
	public String getVenueName() {
		return venueName;
	}
	
	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}


	/*
	 * public List<String[]> getSeats() { return seats; }
	 * 
	 * public void setSeats(ArrayList<String[]> seats) { this.seats = seats;
	 * seats.forEach((s) -> capacity += Integer.parseInt(s[1])); }
	 * 
	 * public void addSeats(String[] seats) { this.seats.add(seats); }
	 * 
	 * public void addBulkSeats(ArrayList<String[]> seats) { for(String[] s : seats)
	 * addSeats(s); }
	 */

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	

}
