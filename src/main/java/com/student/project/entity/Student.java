package com.student.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long rollNo;
	
	private String name;
	
	private String email;
	
	private String course;
	
	private  String  year;
	
    
	public Long getRollNo() {
		return rollNo;
	}
	
	public void setRollNo(Long rollNo) {
		this.rollNo = rollNo;	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCourse() {
		return course;	
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getYear() {
		return year;	
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", email=" + email + ", course=" + course + ", year="
				+ year + "]";
	}
	
	}
	

	
	


