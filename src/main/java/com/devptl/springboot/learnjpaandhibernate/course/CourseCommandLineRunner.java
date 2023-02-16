package com.devptl.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.devptl.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

// Command line for JDBC...	
//	@Autowired
//	private CourseJdbcRepository repository;

//Command line for JPA...
//	@Autowired
//	private CourseJpaRepository repository;

//Command line for Spring JPA...
	@Autowired
	private CourseSpringDataJpaRepository repository;

//@Override annotation indicates that the child class method is over-writing its base class method.
//It extracts a warning from the compiler if the annotated method doesn't actually override anything.
	@Override
	public void run(String... args) throws Exception {

//  QUERIES FOR JDBC & JPA...
		// Inserting data..
//		repository.insert(new Course(1, "learn ABC", "Dev PTL"));
//		repository.insert(new Course(2, "learn cvb", "vbc PTL"));
//		repository.insert(new Course(3, "learn vbc", "cvb PTL"));
//		repository.insert(new Course(4, "learn bvc", "vbf PTL"));

		// Deleting data..
//		repository.deleteById(1);

		// Finding data/ To show data..
//		System.out.println(repository.findById(2));
//		System.out.println(repository.findById(3));
//		System.out.println(repository.findById(4));

//  QUERIES FOR SPRING JPA...
		// Inserting data..
		// Instead of "insert" here "save" used in Spring JPA.
		repository.save(new Course(1, "learn ABC", "Dev PTL"));
		repository.save(new Course(2, "learn cvb", "vbc PTL"));
		repository.save(new Course(3, "learn vbc", "Dev PTL"));
		repository.save(new Course(4, "learn bvc", "vbf PTL"));
		repository.save(new Course(5, "learn cvb", "vbc PTL"));
		repository.save(new Course(6, "learn cvb", "vbc PTL"));
		repository.save(new Course(7, "learn cvb", "vbc PTL"));

		// Deleting data..
		// in spring JPA id written with "long" means to write id=1 we write "1l"
		// This rule is same for delete and find both method.
		repository.deleteById(1l);

		// Finding data/ To show data..
		// use for spring JPA
		System.out.println(repository.findById(2l));
		System.out.println(repository.findById(3l));
		System.out.println(repository.findById(4l));

		// EXTRA FEATURES OF SPRING JPA...
		// Exploring MORE Features of Spring Data JPA.
		System.out.println(repository.findAll());
		System.out.println(repository.count());

		// Use custom method which we are made "findByAuthor".
		System.out.println(repository.findByAuthor("Dev PTL"));

		// custom method search by course name.
		System.out.println(repository.findByName("learn cvb"));

	}

}
