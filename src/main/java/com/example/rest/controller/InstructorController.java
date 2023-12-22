package com.example.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.payload.InstructorDto;
import com.example.rest.service.InstructorService;

@RestController
@RequestMapping("/create")
public class InstructorController {

	@Autowired
	private InstructorService instructorService;
	
	@PostMapping("/")
	public ResponseEntity<InstructorDto>createInstructor(@RequestBody InstructorDto dto){
		InstructorDto createInstructor = this.instructorService.createInstructor(dto);
		return new ResponseEntity<InstructorDto>(createInstructor,HttpStatus.CREATED);
	}
}
