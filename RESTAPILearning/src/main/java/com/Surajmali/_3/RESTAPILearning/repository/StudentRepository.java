package com.Surajmali._3.RESTAPILearning.repository;

import com.Surajmali._3.RESTAPILearning.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student , Long> {

}
