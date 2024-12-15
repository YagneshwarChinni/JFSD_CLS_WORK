package com.klef.jfsd.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="patient_table")
public class Patient 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="dr_id")
	private int id;
	@Column(name="p_name",nullable=false,length = 50)
	private String name;
	@Column(name="p_gender",nullable=false,length = 20)
	private String gender;
	@Column(name="p_dob",nullable=false,length = 20)
	private String dateofbirth;
	@Column(name="dr_email",nullable=false,unique = true,length = 50)
	private String email;
	@Column(name="p_password",nullable=false,length = 50)
	private String password;
	@Column(name="p_location",nullable=false,length=50)
	private String location;
	@Column(name="p_contact",nullable=false,unique = true,length = 20)
	private String contact;
	@Column(name="p_bloodgroup",nullable=false,unique = true,length = 20)
	private String bloodgroup;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	
	
}
