package com.example.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.model.Lecture;

public interface LectureRepo extends JpaRepository<Lecture, Integer> {

}
