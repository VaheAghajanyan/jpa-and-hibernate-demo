package com.synisys.jpaandhibernate.jpa;

import com.synisys.jpaandhibernate.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
    List<Course> findAllByAuthor(String author);
    List<Course> findAllByName(String name);
}
