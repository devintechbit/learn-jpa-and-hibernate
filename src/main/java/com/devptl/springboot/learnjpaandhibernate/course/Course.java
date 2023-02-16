package com.devptl.springboot.learnjpaandhibernate.course;

//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//Entity: The entities are the persistence objects stores as a record i DB
//Persistence Unit: It defines a set of all entity classes.
//In an application, EntityManager instances manage it. 
//The set of entity classes represents the data contained within a single data store.

@Entity // (name="table_name")
		// It used when table name and class or Bean name is different...
public class Course {

	@Id // It denotes primary key...
	private long id;

	// @Column(name="name") //if name is dif from database table...
	private String name;

	// @Column(name="author") //if name is dif from database table...
	private String author;

	// creating following things...
	// 1) constructor with value and w/o value...
	// 2) getters and setters
	// 3) ToString method by using field...

	// constructor w/o value..
	public Course() {

	}

	// constructor with value..
	public Course(long id, String name, String author) {
		super(); // If we used parameterized constructor then super() is required. It has to be called by subclass constructor.
		this.id = id;
		this.name = name;
		this.author = author;
	}

	// getters and setters..
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	// ToString method by using field..
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}

}
