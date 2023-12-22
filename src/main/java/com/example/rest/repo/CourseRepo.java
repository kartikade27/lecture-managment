package com.example.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.model.Course;

public interface CourseRepo extends JpaRepository<Course, Integer> {

}
