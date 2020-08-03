package com.tjib.app.event;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjib.app.entities.Ticket;
import com.tjib.app.entities.TicketRepository;

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
	
	public List<Ticket> getEventAvailableTickets(int id) {
		return repository.findById(id).get().availableTickets();
	}
	
	public void addEvent(Event event) {
		repository.save(event);
	}
	
	public void updateEvent(int id, Event event) {
		repository.save(event);
	}
	
	public void addTickets(int id, int numOfTickets, String section, int price, boolean marked) {
		Event e = repository.findById(id).get();
		
		for(int i=0; i<numOfTickets; i++){
			Ticket tickets = new Ticket();
			tickets.setEvent(e);
			tickets.setSection(section);
			if(marked) tickets.setPosition(i+1);
			else tickets.setPosition(0);
			tickets.setPrice(price);
			tickets.setStatus("available");
			tickets.setMarked(marked);
			ticketRepository.save(tickets);
			e.addTicket(tickets);
		}
		repository.save(e);
	}
	
	public void deleteEvent(int id) {
		repository.deleteById(id);
	}
	
	public void deleteAllEvents() {
		ticketRepository.deleteAll();
		repository.deleteAll();
	}
	

}
