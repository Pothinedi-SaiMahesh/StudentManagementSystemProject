package com.student.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.project.entity.Student;
import com.student.project.repo.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
	//postmapping
	public Student save(Student student) {
		return repo.save(student);
	}
	//getid
	public Student getById(Long id) {
		return repo.findById(id).orElseThrow(()-> new RuntimeException("Student not found woth id"+id));
	}
	//getall
	public List<Student> getAll(){
		return repo.findAll();
	}
	//delete
	public void deleteById(Long id) {
		repo.deleteById(id);	
	}
	//update
	public Student update(Long id,Student student) {
	
	Student existingStudent = 	repo.findById(id).orElseThrow(()-> new RuntimeException("Student not found with id"+id));
	existingStudent.setName(student.getName());
	existingStudent.setEmail(student.getEmail());
	existingStudent.setCourse(student.getCourse());
	existingStudent.setYear(student.getYear());
	return repo.save(existingStudent);
	
	}
	//patch update
	public Student patchUpdate(Long id,Student student) {
	Student existingStudent = repo.findById(id).orElseThrow(()-> new RuntimeException("Student not found with id"+id));
	if(existingStudent!=null) {
		if(student.getName()!=null) {
			existingStudent.setName(student.getName());	
		}
		if(student.getEmail()!=null) {
			existingStudent.setEmail(student.getEmail());
		}
		if(student.getCourse()!=null) {
			existingStudent.setCourse(student.getCourse());
		}
		if(student.getYear()!=null) {
			existingStudent.setYear(student.getYear());
		}
		return repo.save(existingStudent);
	}
	return null;
	}
	
	public Student getByName(String name) {
		return repo.findByName(name);
	}
    
	public Student getByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	public Student getByEmailAndYear(String email,String year) {
		return repo.findByEmailAndYear(email, year);
	}

	

}
