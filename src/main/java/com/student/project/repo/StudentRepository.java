package com.student.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.project.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	public Student findByName(String name);
	
	
}
