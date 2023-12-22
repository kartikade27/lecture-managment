package com.example.rest.service;

import java.util.List;

import com.example.rest.payload.LectureDto;

public interface LectureService {

	LectureDto createLectureWithInstuctorAndCourse(LectureDto dto,Integer instructorId,Integer courseId);
	
	List<LectureDto> findAllLecture();
}
