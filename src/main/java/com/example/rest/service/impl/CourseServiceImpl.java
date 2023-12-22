package com.example.rest.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.model.Course;
import com.example.rest.payload.CourseDto;
import com.example.rest.repo.CourseRepo;
import com.example.rest.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepo repo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public CourseDto createCourse(CourseDto courseDto) {

		Course course = this.mapper.map(courseDto, Course.class);
		Course courses = this.repo.save(course);
		return this.mapper.map(courses, CourseDto.class);
	}

	@Override
	public List<CourseDto> findAllCourse() {

		List<Course> courses = this.repo.findAll();
		List<CourseDto> coursesDto = courses.stream().map((course) -> this.mapper.map(course, CourseDto.class))
				.collect(Collectors.toList());
		return coursesDto;

	}

}
