package com.devptl.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.devptl.springboot.learnjpaandhibernate.course.Course;

@Repository
public class CourseJdbcRepository {

	@Autowired
	private JdbcTemplate springJdbcTemplate;

	private static String INSERT_QUERY =

			"""
						insert into course (id, name, author)
						values(?,?,?);
					""";

	// It used before creating COURSE class...
	// """
	// insert into course (id, name, author)
	// values(1, 'Learn AWS', 'DevPtl');
	// """;

	private static String DELETE_QUERY =

			"""
						delete from course
						where id = ?
					""";

	private static String SELECT_QUERY =

			"""
						select * from course
						where id = ?
					""";

	// For inserting Data...

	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());

	}

	// For deleting data...
	public void deleteById(long id) {
		springJdbcTemplate.update(DELETE_QUERY, id);

	}

//This findById  method is more complex then others...
	// three parameters query, RowMapper Bean Class of course, and id..
	// 1) SELECT_QUERY
	// 2) ResultSet -> Bean => RowMapper
	// 3) id

	// To show inserted data...
	public Course findById(long id) {
		return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);

	}
}
