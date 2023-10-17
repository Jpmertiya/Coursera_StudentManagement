package com.Gym.Star.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Gym.Star.Entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{
	
}
