package com.example.rest.service;

import java.util.List;

import com.example.rest.payload.CourseDto;

public interface CourseService {

	CourseDto createCourse(CourseDto courseDto);
	
	List<CourseDto>findAllCourse();
}
