package com.hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/*
 * Now we will use some annotation to tell hibernate that use this 
 * class as an entity
 * */

// here student_details we changed the name of the entity from student(class Name) to student_details
//@Entity(name="student_details")

// If we want that our entity name will be className only but table name should be different
// then we have use the annotation @Table(name="my_students") annotation


@Entity
public class Student {
	// This @Id will make the id as primary key 
	// If we want any other thing to be primary key then write @Id on the top of them
	// Now we are going to tell hibernate about this class in hibernate.cfg.xml file
	@Id
	private int id;
	private String name;
	private String city;
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
	
}
