package com.tjib.app.venue;

import javax.persistence.*;

/*
 * Represents a venue where an event takes place
 */

@Entity
@Table(name = "tbl_venue")
public class Venue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String venueName;
	private String location;
	private int capacity;

	
	public Venue() {} //empty constructor for jpa
	
	public Venue(String venueName, String location, int capacity) { //constructor
		this.venueName = venueName;
		this.location = location;
		this.capacity = capacity;
	}
	
	//getters and setters
	
	public int getId() {
		return id;
	}
	
	public String getVenueName() {
		return venueName;
	}
	
	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

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
