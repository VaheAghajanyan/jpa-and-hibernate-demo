package com.synisys.jpaandhibernate.jdbc;

import com.synisys.jpaandhibernate.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_QUERY =
            """
            INSERT INTO course (id, name, author)
            VALUES (?, ?, ?);
            """;

    private static final String DELETE_QUERY =
            """
            DELETE FROM course 
            WHERE id = ?
            """;

    private static final String SELECT_BY_ID =
            """
            SELECT * FROM course
            WHERE id = ?
            """;

    public void insert(Course course) {
        this.jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void delete(long id) {
        this.jdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course select(long id) {
        return this.jdbcTemplate.queryForObject(SELECT_BY_ID, new BeanPropertyRowMapper<>(Course.class), id);
    }
}
