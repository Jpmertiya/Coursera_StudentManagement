package com.Gym.Star.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Gym.Star.Entity.Student;
import com.Gym.Star.Service.StudentImpl;

@RestController
@RequestMapping("/api")
public class HomeController {

	@Autowired
	private StudentImpl impl;

	@GetMapping("/")
	public String home() {
		return "this is testing";
	}

//	to get students
	@GetMapping("/students")
	public List<Student> getAllStudent() {
		return impl.findAll();
	}

//	to save student
	@PostMapping("/student")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		return ResponseEntity.ok(impl.save(student));
	}

//	get student by id
	@GetMapping("/student/{id}")
	public Optional<Student> getById(@PathVariable("id") int id) {
		return impl.findById(id);
	}

//	to update Student
	@PutMapping("/student/{id}")
	public Student update(@PathVariable("id") int id, @RequestBody Student student) {
		student.setId(id);
		return impl.save(student);
	}

//	 to delete Student
	@DeleteMapping("/student/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		impl.deleteByID(id);
		HttpStatus httpStatus = HttpStatus.NO_CONTENT;
		String message = "This is a custom message for a Bad Request.";
		return new ResponseEntity<>(message, httpStatus);
	}
}
