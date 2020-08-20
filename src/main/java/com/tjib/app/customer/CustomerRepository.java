package com.tjib.app.customer;


import org.springframework.data.repository.CrudRepository;

/*
 * Repository to store customer entities
 */

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	
	public Customer findByEmail(String email); //find a customer by its email address


}
