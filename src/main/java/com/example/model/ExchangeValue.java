package com.example.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;




@Entity  
@Table(name="Exchange_Value")  

public class ExchangeValue   
{  
@Id
@Column(name="id")
@GeneratedValue(strategy=GenerationType.AUTO)
private long id;
@Column(name="name") 
@NotNull(message="Email is compulsory")
@Size(min=3,message="should be at least 3 characters")
private String name ;
@NotNull(message="Email is compulsory")
@Column(name="contactnumber")
private String contactnumber;
@Size(min=3,message="should be at least 3 characters")
@NotNull(message="Email is compulsory")
@Column(name ="airport")
private String airport;
@Column(name="currency_from")  
private String from;  
@Column(name="currency_to")  
private String to;  
@Column(name="departuretime")
@CreationTimestamp
private Date estimatedTravelTime;
@Column(name="Deadline")  
private String deadline;  
@Column(name="port")  
private int port;  
//default constructor  
public ExchangeValue()  
{  
	
}  
public ExchangeValue(long id, String name, String contactnumber, String airport, String from, String to,Date estimatedTravelTime, String deadline,
		int port) {
	super();
	this.id = id;
	this.name = name;
	this.contactnumber = contactnumber;
	this.airport = airport;
	this.from = from;
	this.to = to;
	this.estimatedTravelTime=estimatedTravelTime;
	this.deadline = deadline;
	this.port = port;
}






public long getId() {
	return id;
}




public void setId(long id) {
	this.id = id;
}




public String getName() {
	return name;
}




public Date getEstimatedTravelTime() {
	return estimatedTravelTime;
}




public void setEstimatedTravelTime(Date estimatedTravelTime) {
	this.estimatedTravelTime = estimatedTravelTime;
}




public void setName(String name) {
	this.name = name;
}




public String getContactnumber() {
	return contactnumber;
}




public void setContactnumber(String contactnumber) {
	this.contactnumber = contactnumber;
}




public String getAirport() {
	return airport;
}




public void setAirport(String airport) {
	this.airport = airport;
}




public String getFrom() {
	return from;
}




public void setFrom(String from) {
	this.from = from;
}




public String getTo() {
	return to;
}




public void setTo(String to) {
	this.to = to;
}




public String getDeadline() {
	return deadline;
}




public void setDeadline(String deadline) {
	this.deadline = deadline;
}




public int getPort() {
	return port;
}




public void setPort(int port) {
	this.port = port;
}




@Override
public String toString() {
	return "ExchangeValue [id=" + id + ", name=" + name + ", contactnumber=" + contactnumber + ", airport=" + airport
			+ ", from=" + from + ", to=" + to + ", deadline=" + deadline + ", port=" + port + "]";
}
}






