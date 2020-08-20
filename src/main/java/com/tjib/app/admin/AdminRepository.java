package com.tjib.app.admin;

import org.springframework.data.repository.CrudRepository;

/*
 * Repository to store admin entities
 */

public interface AdminRepository extends CrudRepository<Admin, String> {
	
	public Admin findByEmail(String email); //find an admin by its email address

}
