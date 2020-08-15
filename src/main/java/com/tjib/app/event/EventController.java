package com.tjib.app.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.tjib.app.entities.Ticket;

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
	
	@RequestMapping("/events/{id}/availabletickets")
	public List<Ticket> getEventAvailableTickets(@PathVariable int id) {
		return service.getEventAvailableTickets(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/events")
	public Event addEvent (@RequestBody Event event) {
		return service.addEvent(event);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/events/{id}")
	public void updateEvent(@PathVariable int id, @RequestBody Event event) {
		service.updateEvent(id, event);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/events/{id}/addtickets")
	public void addTickets(@PathVariable int id, @RequestParam int numOfTickets, @RequestParam String section, @RequestParam Integer price) {
		service.addTickets(id, numOfTickets, section, price);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/events/{id}")
	public void deleteEvent(@PathVariable int id) {
		service.deleteEvent(id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/events")
	public void deleteAllEvents() {
		service.deleteAllEvents();
	}

}
