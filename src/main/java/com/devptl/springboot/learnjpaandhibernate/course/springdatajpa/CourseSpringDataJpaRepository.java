package com.devptl.springboot.learnjpaandhibernate.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devptl.springboot.learnjpaandhibernate.course.Course;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {

	// You can make custom methods in Spring JPA...

	// create Custom method to search by author...
	List<Course> findByAuthor(String author);

	// create Custom method to search by course name...
	List<Course> findByName(String name);

}
