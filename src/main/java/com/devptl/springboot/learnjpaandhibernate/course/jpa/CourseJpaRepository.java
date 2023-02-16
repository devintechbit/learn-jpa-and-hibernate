package com.devptl.springboot.learnjpaandhibernate.course.jpa;

import org.springframework.stereotype.Repository;

import com.devptl.springboot.learnjpaandhibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository

//We can use @Transactional to wrap a method in a database transaction. 
//It allows us to set propagation, isolation, timeout, read-only, and rollback conditions for our transaction.
@Transactional
public class CourseJpaRepository {

//	@Autowired
	@PersistenceContext // It is alternative of @Autowired which is specialized annotation.
	private EntityManager entityManager;

	// EntityManager is used for mapping in JPA and used to manage entity
	// you can perform operation like insert, find, remove/delete entities etc...
	// we not worry about queries while used EntityManager
	// by using EntityManager we can easily insert data using JPA...
	// Don't worry about write SQL Query..

	// For inserting Data...
	public void insert(Course course) {
		entityManager.merge(course);
	}

	// For deleting data...
	public void deleteById(long id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}

	// To show inserted data...
	public Course findById(long id) {
		return entityManager.find(Course.class, id);
	}

}
