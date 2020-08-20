package com.tjib.app.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Controller for admin requests
 * Handles requests related to admin that sent to the server and sends responses
 * Allows communication between the server and the client
 */

@RestController
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@RequestMapping("/admins")
	public List<Admin> getAllAdmins() {
		return service.getAllAdmins();
	}
	
	@RequestMapping("/admins/{id}")
	public Admin getAdmin(@PathVariable String id) {
		return service.getAdmin(id);
	}
	
	@RequestMapping("/admins/login")
	public Admin login(@RequestParam String email, @RequestParam String password) {
		return service.findAdmin(email, password);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/admins")
	public void addAdmin (@RequestBody Admin admin) {
		service.addAdmin(admin);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/adminslist")
	public void addAdmins (@RequestBody List<Admin> admins) {
		service.addAdmins(admins);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/admins/{id}")
	public void updateAdmin(@PathVariable String id, @RequestBody Admin admin) {
		service.updateAdmin(id, admin);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/admins/{id}")
	public void deleteAdmin(@PathVariable String id) {
		service.deleteAdmin(id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/admins")
	public void deleteAllAdmins() {
		service.deleteAllAdmins();
	}

}
