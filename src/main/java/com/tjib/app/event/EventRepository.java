package com.tjib.app.event;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Integer> {
	
	public List<Event> findByEventType(String eventType);

}
