package com.tjib.app.admin;

import javax.persistence.*;

/*
 * Represents an administrator of the application
 * Can edit, add or remove events, add venues, track orders
 */

@Entity
@Table(name = "tbl_admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;
	private String password;
	private String email;

	public Admin() {} //empty constructor for jpa
	
	public Admin(String username, String password, String email) { //constructor
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	//getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
