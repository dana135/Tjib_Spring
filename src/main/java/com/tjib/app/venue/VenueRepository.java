package com.tjib.app.venue;

import org.springframework.data.repository.CrudRepository;

/*
 * Repository to store venue entities
 */

public interface VenueRepository extends CrudRepository<Venue, Integer> {
	

}
