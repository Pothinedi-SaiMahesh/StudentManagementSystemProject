package com.student.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.project.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    
	public Student findByName(String name);
	
	public Student findByEmail(String email);
	
	public Student findByEmailAndYear(String email,String year);
	
	public Student findByCourse(String course);
	
	public List<Student> findByYear(String year);
	
}
