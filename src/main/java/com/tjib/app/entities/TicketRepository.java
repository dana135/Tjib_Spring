package com.tjib.app.entities;

import org.springframework.data.repository.CrudRepository;

/*
 * Repository to store ticket entities
 */

public interface TicketRepository extends CrudRepository<Ticket, Integer> {

}
