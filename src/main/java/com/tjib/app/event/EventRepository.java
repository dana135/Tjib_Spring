package com.tjib.app.event;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/*
 * Repository to store event entities
 */

public interface EventRepository extends CrudRepository<Event, Integer> {
	
	public List<Event> findByEventType(String eventType); //find events of a certain type

}
