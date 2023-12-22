package com.example.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.payload.CourseDto;
import com.example.rest.payload.LectureDto;
import com.example.rest.service.CourseService;
import com.example.rest.service.LectureService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private CourseService courseService;
	@Autowired
	private LectureService lectureService;
	
	@PostMapping("/")
	public ResponseEntity<CourseDto>createCourse(@RequestBody CourseDto courseDto){
		CourseDto createCourse = this.courseService.createCourse(courseDto);
		return new ResponseEntity<CourseDto>(createCourse,HttpStatus.CREATED);
	}
	@GetMapping("/")
	public ResponseEntity<List<CourseDto>>findAllCourses(){
		List<CourseDto> findAllCourse = this.courseService.findAllCourse();
		return new ResponseEntity<List<CourseDto>>(findAllCourse,HttpStatus.OK);
	}
	
	//create lecture with courseId and instructorId
	
	@PostMapping("/instructor/{instructorId}/course/{courseId}/lecture")
	public ResponseEntity<LectureDto>createLectureWithInstructorAndCourse(@RequestBody LectureDto lectureDto,
			@PathVariable("instructorId")Integer instructorId,
			@PathVariable("courseId")Integer CourseId
			){
		LectureDto createLectureWithInstuctorAndCourse = this.lectureService.createLectureWithInstuctorAndCourse(lectureDto, instructorId, CourseId);
	
	   return new ResponseEntity<LectureDto>(createLectureWithInstuctorAndCourse,HttpStatus.CREATED);
	}
	
	// find all lectures
	@GetMapping("/lectures")
	public ResponseEntity<List<LectureDto>>findAllLecture(){
		List<LectureDto> findAllLecture = this.lectureService.findAllLecture();
		return new ResponseEntity<List<LectureDto>>(findAllLecture,HttpStatus.NOT_ACCEPTABLE);
	}
}
