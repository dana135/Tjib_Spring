package com.tjib.app.venue;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Service for venue requests
 * Implements the logic required to handle requests and updates the database
 * Allows communication between the controller and the repository
 */

@Service
public class VenueService {
	
	@Autowired
	private VenueRepository repository;
	
	public List<Venue> getAllVenues() {
		List<Venue> venues = new ArrayList<>();
		repository.findAll().forEach(venues::add);
		return venues;
	}
	
	public Venue getVenue(int id) {
		return repository.findById(id).get();
	}
	
	public void addVenue(Venue venue) {
		repository.save(venue);
	}
	
	public void addVenues(List<Venue> venues) {
		for(Venue venue : venues)
			repository.save(venue);
	}
	
	public void updateVenue(int id, Venue venue) {
		repository.save(venue);
	}
	
	public void deleteVenue(int id) {
		repository.deleteById(id);
	}
	
	public void deleteAllVenues() {
		repository.deleteAll();
	}

}
