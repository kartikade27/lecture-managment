package com.example.rest.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.model.Instructor;
import com.example.rest.payload.InstructorDto;
import com.example.rest.repo.InstructorRepo;
import com.example.rest.service.InstructorService;

@Service
public class InstructorServiceImpl implements InstructorService {
	
	@Autowired
	private InstructorRepo repo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public InstructorDto createInstructor(InstructorDto dto) {
       Instructor instructor = this.mapper.map(dto, Instructor.class);
       Instructor instructorDto = this.repo.save(instructor);
       return this.mapper.map(instructorDto, InstructorDto.class);
       
		
	}

}
