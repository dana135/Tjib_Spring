package com.tjib.app.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
	
	@RequestMapping(method=RequestMethod.POST, value="/admins")
	public void addAdmin (Admin admin) {
		service.addAdmin(admin);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/admins/{id}")
	public void updateAdmin(@PathVariable String id, Admin admin) {
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
