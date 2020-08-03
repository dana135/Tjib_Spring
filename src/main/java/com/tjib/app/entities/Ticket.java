package com.tjib.app.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tjib.app.event.Event;

@Entity
@Table(name = "tbl_ticket")
@JsonIgnoreProperties({"event", "customer"})
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "event_id")
	@JsonIgnoreProperties("tickets")
	private Event event;
	private String section;
	//0 if unmarked
	private int position;
	private int price;
	private String status;
	@Column(nullable = true, columnDefinition = "BOOLEAN DEFAULT TRUE")
	private boolean marked;
	
	public Ticket() {}
	
	public Ticket(int num, Event event, String section, int position, int price, boolean marked) {
		this.position = num;
		this.event = event;
		this.section = section;
		this.position = position;
		this.price = price;
		this.status = "available";
		this.marked = marked;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public int getPosition() {
		return position;
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

	public boolean isMarked() {
		return marked;
	}

	public void setMarked(boolean marked) {
		this.marked = marked;
	}
	

}
