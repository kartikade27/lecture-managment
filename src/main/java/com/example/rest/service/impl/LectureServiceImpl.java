package com.example.rest.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.exception.CustomeException;
import com.example.rest.model.Course;
import com.example.rest.model.Instructor;
import com.example.rest.model.Lecture;
import com.example.rest.payload.LectureDto;
import com.example.rest.repo.CourseRepo;
import com.example.rest.repo.InstructorRepo;
import com.example.rest.repo.LectureRepo;
import com.example.rest.service.LectureService;

@Service
public class LectureServiceImpl implements LectureService {

	@Autowired
	private LectureRepo lectureRepo;
	@Autowired
	private InstructorRepo instructorRepo;
	@Autowired
	private CourseRepo courseRepo;
	@Autowired
	private ModelMapper modelMapper;

	@SuppressWarnings("deprecation")
	@Override
	public LectureDto createLectureWithInstuctorAndCourse(LectureDto dto, Integer instructorId, Integer courseId) {

		Instructor instuctor = this.instructorRepo.findById(instructorId)
				.orElseThrow(() -> new CustomeException("instructor not found"));
		Course course = this.courseRepo.findById(courseId).orElseThrow(() -> new CustomeException("course not found"));
		Lecture lecture = this.modelMapper.map(dto, Lecture.class);
		for (Lecture lect : instuctor.getLectures()) {

			if (lecture.getDate().getDate() == lect.getDate().getDate()) {
				throw new CustomeException("instructor not availble on this date");
			}
		}
	

		lecture.setCourse(course);
		lecture.setInstructor(instuctor);
		Lecture addedLecture = this.lectureRepo.save(lecture);

		return this.modelMapper.map(addedLecture, LectureDto.class);

	}

	@Override
	public List<LectureDto> findAllLecture() {

		List<Lecture> lecturs = this.lectureRepo.findAll();
		List<LectureDto> lectureDto = lecturs.stream().map((lecture) -> this.modelMapper.map(lecture, LectureDto.class))
				.collect(Collectors.toList());

		return lectureDto;
	}

}
