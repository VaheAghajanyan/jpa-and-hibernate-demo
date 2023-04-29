package com.synisys.jpaandhibernate.jpa;

import com.synisys.jpaandhibernate.model.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Course course) {
        this.entityManager.merge(course);
    }

    public Course findById(long id) {
        return this.entityManager.find(Course.class, id);
    }

    public void deleteById(long id) {
        Course course = this.findById(id);
        this.entityManager.remove(course);
    }
}
