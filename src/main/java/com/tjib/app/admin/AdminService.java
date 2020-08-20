package com.tjib.app.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Service for admin requests
 * Implements the logic required to handle requests and updates the database
 * Allows communication between the controller and the repository
 */

@Service
public class AdminService {

	@Autowired
	private AdminRepository repository;

	public List<Admin> getAllAdmins() {
		List<Admin> admins = new ArrayList<>();
		repository.findAll().forEach(admins::add);
		return admins;
	}

	public Admin getAdmin(String id) {
		return repository.findById(id).get();
	}
	
	public Admin findAdmin(String email, String password) { //confirm admin by email and password
		Admin admin = repository.findByEmail(email);
		if(admin != null && admin.getPassword().equals(password)) return admin; //email exists and password is correct
		return null; //no such admin
	}

	public void addAdmin(Admin admin) {
		repository.save(admin);
	}
	
	public void addAdmins(List<Admin> admins) {
		for(Admin admin : admins)
			repository.save(admin);
	}

	public void updateAdmin(String id, Admin admin) {
		repository.save(admin);
	}

	public void deleteAdmin(String id) {
		repository.deleteById(id);
	}

	public void deleteAllAdmins() {
		repository.deleteAll();
	}

}
