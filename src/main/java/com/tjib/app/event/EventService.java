package com.tjib.app.event;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjib.app.entities.Ticket;
import com.tjib.app.entities.TicketRepository;

/*
 * Service for event requests
 * Implements the logic required to handle requests and updates the database
 * Allows communication between the controller and the repository
 */

@Service
public class EventService {
	
	@Autowired
	private EventRepository repository;
	@Autowired
	private TicketRepository ticketRepository;
	
	public List<Event> getAllEvents() {
		List<Event> events = new ArrayList<>();
		repository.findAll().forEach(events::add);
		return events;
	}
	
	public List<Event> getLiveConcerts() {
		return repository.findByEventType("Live Concert");
	}
	
	public List<Event> getOnlineConcerts() {
		return repository.findByEventType("Online Concert");
	}
	
	public List<Event> getFanMeetings() {
		return repository.findByEventType("Fan Meeting");
	}
	
	public Event getEvent(int id) {
		return repository.findById(id).get();
	}
	
	public List<Ticket> getEventTickets(int id) {
		return repository.findById(id).get().getTickets();
	}
	
	public Event addEvent(Event event) {
		 repository.save(event);
		 return event;
	}
	
	public void addEvents(List<Event> events) {
		for(Event event : events)
			repository.save(event);
	}
	
	public void updateEvent(int id, Event event) {
		Event e = repository.findById(id).get();
		e.setName(event.getName());
		e.setEventType(event.getEventType());
		e.setDateAndTime(event.getDateAndTime());
		e.setVenueName(event.getVenueName());
		e.setImage(event.getImage());
		repository.save(e);
	}
	
	//add tickets of a specific section to an event
	public void addTickets(int id, int numOfTickets, String section, int price) {
		Event e = repository.findById(id).get();
		
		for(int i=0; i<numOfTickets; i++){
			Ticket tickets = new Ticket(); //create new ticket entity
			//set ticket fields
			tickets.setEventName(e.getName());
			tickets.setSection(section);
			if(section.equals("SITTING")) //position is 0 for unmarked tickets (standing or vip)
				tickets.setPosition(i+1);
			else tickets.setPosition(0);
			tickets.setPrice(price);
			tickets.setStatus("available");
			
			ticketRepository.save(tickets);
			e.addTicket(tickets);
		}
		repository.save(e);
	}
	
	//add multiple tickets to multiple events, used for database initialization
	public void addTicketsList(List<String[]> details) {
		for(String[] string : details) {
			int id = Integer.valueOf(string[0]); //current event id
			int numOfTickets = Integer.valueOf(string[1]);
			String section = string[2];
			int price = Integer.valueOf(string[3]);
			
			addTickets(id, numOfTickets, section, price);
		}
		
	}
	
	public void deleteEvent(int id) {
		repository.deleteById(id);
	}
	
	public void deleteAllEvents() {
		ticketRepository.deleteAll();
		repository.deleteAll();
	}
	
	public void deleteAllTickets() {
		ticketRepository.deleteAll();
	}
	

}
