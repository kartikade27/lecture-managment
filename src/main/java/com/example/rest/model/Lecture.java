package com.example.rest.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Lecture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String time;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date date;

	@ManyToOne
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;

}
