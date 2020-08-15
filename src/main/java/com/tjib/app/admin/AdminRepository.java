package com.tjib.app.admin;

import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, String> {
	
	public Admin findByEmail(String email);

}
