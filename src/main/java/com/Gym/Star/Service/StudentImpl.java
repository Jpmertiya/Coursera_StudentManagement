package com.Gym.Star.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Gym.Star.Entity.Student;
import com.Gym.Star.Repo.StudentRepo;

@Component
public class StudentImpl {
	@Autowired
	private StudentRepo repo;

	public List<Student> findAll() {
		return repo.findAll();
	}

	public Optional<Student> findById(int id) {
		return repo.findById(id);
	}

	public void deleteByID(int id) {
		repo.deleteById(id);
	}

	public Student save(Student s) {
		return repo.save(s);
	}
}
