package com.tjib.app.order;

import org.springframework.data.repository.CrudRepository;

/*
 * Repository to store order entities
 */

public interface OrderRepository extends CrudRepository<Order, Integer> {

}