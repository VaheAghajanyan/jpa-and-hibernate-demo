package com.synisys.jpaandhibernate.jdbc;

import com.synisys.jpaandhibernate.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository courseJdbcRepository;

    @Override
    public void run(String... args) throws Exception {
        this.courseJdbcRepository.insert(new Course(1, "Learn AWS", "Vahe"));
        this.courseJdbcRepository.insert(new Course(2, "Learn Azure", "Vahe"));
        this.courseJdbcRepository.insert(new Course(3, "Learn GCP", "Vahe"));
        this.courseJdbcRepository.delete(2);

        System.out.println(this.courseJdbcRepository.select(1));
        System.out.println(this.courseJdbcRepository.select(3));
    }
}
