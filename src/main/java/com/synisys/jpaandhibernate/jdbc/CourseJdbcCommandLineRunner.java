package com.synisys.jpaandhibernate.jdbc;

import com.synisys.jpaandhibernate.jpa.CourseJpaRepository;
import com.synisys.jpaandhibernate.jpa.CourseSpringDataJpaRepository;
import com.synisys.jpaandhibernate.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    /*@Autowired
    private CourseJdbcRepository courseJdbcRepository;*/

    /*@Autowired
    private CourseJpaRepository courseJpaRepository;*/

    @Autowired
    private CourseSpringDataJpaRepository courseSpringDataJpaRepository;

    @Override
    public void run(String... args) throws Exception {
        /*this.courseJdbcRepository.insert(new Course(1, "Learn AWS", "Vahe"));
        this.courseJdbcRepository.insert(new Course(2, "Learn Azure", "Vahe"));
        this.courseJdbcRepository.insert(new Course(3, "Learn GCP", "Vahe"));

        this.courseJdbcRepository.delete(2);

        System.out.println(this.courseJdbcRepository.select(1));
        System.out.println(this.courseJdbcRepository.select(3));*/

        /*this.courseJpaRepository.insert(new Course(1, "Learn AWS JPA", "Vahe"));
        this.courseJpaRepository.insert(new Course(2, "Learn Azure JPA", "Vahe"));
        this.courseJpaRepository.insert(new Course(3, "Learn GCP JPA", "Vahe"));

        this.courseJpaRepository.deleteById(2);

        System.out.println(this.courseJpaRepository.findById(1));
        System.out.println(this.courseJpaRepository.findById(3));*/

        this.courseSpringDataJpaRepository.save(new Course(1, "Learn AWS Data JPA", "Vahe"));
        this.courseSpringDataJpaRepository.save(new Course(2, "Learn Azure Data JPA", "Vahe"));
        this.courseSpringDataJpaRepository.save(new Course(3, "Learn GCP Data JPA", "Vahe"));

        this.courseSpringDataJpaRepository.deleteById(2l);

        System.out.println(this.courseSpringDataJpaRepository.findById(1l));
        System.out.println(this.courseSpringDataJpaRepository.findById(2l));
        System.out.println(this.courseSpringDataJpaRepository.findById(3l));
        System.out.println("------------------------");
        System.out.println(this.courseSpringDataJpaRepository.findAllByAuthor("Vahe"));
    }
}
