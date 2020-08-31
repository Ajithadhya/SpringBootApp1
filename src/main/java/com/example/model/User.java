package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;







@Entity
@Table(name="mytable")
public class User {
	
	@Id
	@Column(name="id")
	@NotNull
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@NotNull
	@Column(name="username")
	private String username;
	@NotNull
	@Size(min=3,message="should be at least 3 characters")
	@Column(name="firstname")
	private String firstname;
	@Column(name="lastname")
	@Size(min=3,message="should be at least 3 characters")
	@NotNull
	private String lastname;
	@NotNull
	@Email(message = "Email is invalid")
	@Column(name="email")
	private String email;
	@NotNull
	@Size(min=5,message="Password should be at least 5 characters")
	@Column(name="password")
	private String password;
	
	public User() {
		
	}
	
	
	public User(String username, String firstname, String lastname,String email, String password) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email=email;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				 + ", password=" + password + "]";
	}
	
	
	
	

}
