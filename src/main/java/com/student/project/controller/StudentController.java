package com.student.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.project.entity.Student;
import com.student.project.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	//PostMapping logic
	@PostMapping("/saveall")
	public List<Student> saveStudent(@RequestBody List<Student> student) {
		return studentService.saveallstudnets(student);
	}
	//GetById
	@GetMapping("/{id}")
	public Student getById(@PathVariable Long id) {
		return studentService.getById(id);	
	}
	//GetAll
	@GetMapping("/all")
	public List<Student> getAll(){
		return studentService.getAll();
	}
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable Long id,@RequestBody Student student) {
		return studentService.update(id, student);
	}
	@PatchMapping("/{id}")
	public Student patchUpdate(@PathVariable Long id,@RequestBody Student student) {
		return studentService.patchUpdate(id, student);
	}
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		studentService.deleteById(id);
	}
	@GetMapping("/name/{name}")
	public Student findByName(@PathVariable String name) {
		return studentService.getByName(name);
	}
	@GetMapping("/email/{email}")
	public Student getByName(String name) {
		return studentService.getByName(name);
	}
	@GetMapping("/email/{email}/year/{year}")
	public Student getByEmailAndYear(@PathVariable String email,@PathVariable String year) {
		return studentService.getByEmailAndYear(email, year);
	}
	@GetMapping("/course/{course}")
    public Student getByCourse(@PathVariable String course) {
		return studentService.getByCourse(course);
	}
	@GetMapping("/year/{year}")
	public List<Student> getByYear(@PathVariable String year) {
		return studentService.getByYear(year);
	}
	@GetMapping("/name/{name}/email/{email}")
	public Student getByNameAndEmail(@PathVariable String name,@PathVariable String email) {
		return studentService.getByNameAndEmail(name, email);
	}
	//find by course and year
	@GetMapping("/course/{course}/year/{year}")
	public List<Student> getByCourseAndYear(@PathVariable String course,@PathVariable String year) {
		
		System.out.println(course);
		System.out.println(year);
		
		return studentService.getByCourseAndYear(course, year);
	}
}
