package com.tjib.app.venue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VenueController {
	
	@Autowired
	private VenueService service;
	
	@RequestMapping("/venues")
	public List<Venue> getAllVenues() {
		return service.getAllVenues();
	}
	
	@RequestMapping("/venues/{id}")
	public Venue getVenue(@PathVariable int id) {
		return service.getVenue(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/venues")
	public void addVenue(Venue venue) {
		service.addVenue(venue);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/venues/{id}")
	public void updateVenue(@PathVariable int id, Venue venue) {
		service.updateVenue(id, venue);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/venues/{id}")
	public void deleteVenue(@PathVariable int id) {
		service.deleteVenue(id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/venues")
	public void deleteAllVenues() {
		service.deleteAllVenues();
	}

}
