package com.klef.jfsd.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="doctor_table")
public class Doctor 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="dr_id")
	private int id;
	@Column(name="dr_name",nullable=false,length = 50)
	private String name;
	@Column(name="dr_gender",nullable=false,length = 20)
	private String gender;
	@Column(name="dr_dob",nullable=false,length = 20)
	private String dateofbirth;
	@Column(name="dr_email",nullable=false,unique = true,length = 50)
	private String email;
	@Column(name="dr_password",nullable=false,length = 50)
	private String password;
	@Column(name="dr_location",nullable=false,length=50)
	private String location;
	@Column(name="dr_contact",nullable=false,unique = true,length = 20)
	private String contact;
	@Column(name="dr_bloodgroup",nullable=false,unique = true,length = 20)
	private String bloodgroup;
	@Column(name = "dr_specialization", nullable = false, length = 50)
	private String specialization;
	@Column(name = "dr_experience_years", nullable = false)
	private int experienceYears;
    @Column(name = "dr_consultation_fee", nullable = false)
	private double consultationFee;
    @Column(name = "dr_availability", nullable = false, length = 100)
	private String availability; 
    @Column(name = "dr_qualification", nullable = false, length = 100)
	private String qualification;
    @Column(name = "dr_status", nullable = false, length = 20)
    private String status;
    @Column(name = "dr_profile_picture", length = 100)
	private String profilePicture;
    @Column(name = "dr_bio", length = 500)
	private String bio;
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
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public int getExperienceYears() {
		return experienceYears;
	}
	public void setExperienceYears(int experienceYears) {
		this.experienceYears = experienceYears;
	}
	public double getConsultationFee() {
		return consultationFee;
	}
	public void setConsultationFee(double consultationFee) {
		this.consultationFee = consultationFee;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
}
