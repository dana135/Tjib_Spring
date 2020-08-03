package com.tjib.app.admin;

import javax.persistence.*;

@Entity
@Table(name = "tbl_admin")
public class Admin {
	
	@Id
	private String username;
	private String password;
	
	public Admin() {}
	
	public Admin(String username, String password) {
		this.username = username;
		this.password = password;
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
	
	

}
