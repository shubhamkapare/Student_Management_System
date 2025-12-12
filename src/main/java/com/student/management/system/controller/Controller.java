package com.student.management.system.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.student.management.system.entity.Student;
import com.student.management.system.service.StudentService;


@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	private StudentService studentservice;
	
	@GetMapping("/students")
	public String getAllStudents(Model model)
	{
		model.addAttribute("students",studentservice.getAllStudents());
		return "Students.html";
	}
	@GetMapping("/students/new")
	public String createStudentForm(Model model)
	{
//		Student student=new Student();
//		model.addAttribute("student",student);
		return "create-student";
	}
	@PostMapping("/stu")
	public String saveStudent(@ModelAttribute Student student)
	{
		studentservice.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable int id,Model model)
	{
		model.addAttribute("student",studentservice.getById(id));
		return "Edit_Student";
	}
	
	@PostMapping("/students/edit/{id}")
	public String updateStudent(@PathVariable int id, @ModelAttribute Student student)
	{
		Student existingstudent = studentservice.getById(id);
		existingstudent.setFirstname(student.getFirstname());
		existingstudent.setLastname(student.getLastname());
		existingstudent.setEmail(student.getEmail());
		studentservice.saveStudent(existingstudent);
		return "redirect:/students";
	}
	
	@GetMapping("/students/{id}")
	public String deleteById(@PathVariable int id)
	{
		studentservice.deleteById(id);
		return "redirect:/students";
	}
}
