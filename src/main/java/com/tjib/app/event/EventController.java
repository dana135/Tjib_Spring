package com.tjib.app.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.tjib.app.entities.Ticket;

/*
 * Controller for event requests
 * Handles requests related to event and tickets that sent to the server and sends responses
 * Allows communication between the server and the client
 */

@RestController
public class EventController {
	
	@Autowired
	private EventService service;
	
	@RequestMapping("/events")
	public List<Event> getAllEvents() {
		return service.getAllEvents();
	}
	
	@RequestMapping("/events/liveconcerts")
	public List<Event> getLiveConcerts() {
		return service.getLiveConcerts();
	}
	
	@RequestMapping("/events/onlineconcerts")
	public List<Event> getOnlineConcerts() {
		return service.getOnlineConcerts();
	}
	
	@RequestMapping("/events/fanmeetings")
	public List<Event> getFanMeetings() {
		return service.getFanMeetings();
	}
	
	@RequestMapping("/events/{id}")
	public Event getEvent(@PathVariable int id) {
		return service.getEvent(id);
	}
	
	@RequestMapping("/events/{id}/tickets")
	public List<Ticket> getEventTickets(@PathVariable int id) {
		return service.getEventTickets(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/events")
	public Event addEvent (@RequestBody Event event) {
		return service.addEvent(event);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/eventslist")
	public void addEvents (@RequestBody List<Event> events) {
		service.addEvents(events);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/events/{id}")
	public void updateEvent(@PathVariable int id, @RequestBody Event event) {
		service.updateEvent(id, event);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/events/{id}/addtickets")
	public void addTickets(@PathVariable int id, @RequestParam int numOfTickets, @RequestParam String section, @RequestParam Integer price) {
		service.addTickets(id, numOfTickets, section, price);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/events/addticketslist")
	public void addTicketsList(@RequestBody List<String[]> details) {
		service.addTicketsList(details);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/events/{id}")
	public void deleteEvent(@PathVariable int id) {
		service.deleteEvent(id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/events")
	public void deleteAllEvents() {
		service.deleteAllEvents();
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/tickets")
	public void deleteAllTickets() {
		service.deleteAllTickets();
	}

}
