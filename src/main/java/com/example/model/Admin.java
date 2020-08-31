package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name="admintable")
	public class Admin {
		
		@Id
		@Column(name="id")
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int id;
		@Column(name="username")
		private String username;	
		@Column(name="passwords")
		private String passwords;
		public Admin() {
			
		}
		public Admin(int id, String username, String passwords) {
			super();
			this.id = id;
			this.username = username;
			this.passwords = passwords;
		}
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
		public String getPasswords() {
			return passwords;
		}
		public void setPassword(String passwords) {
			this.passwords = passwords;
		}
		@Override
		public String toString() {
			return "Admin [id=" + id + ", username=" + username + ", passwords=" + passwords + "]";
		}
		
		
		
}
