package com.example.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.model.Instructor;

public interface InstructorRepo extends JpaRepository<Instructor, Integer> {

}
