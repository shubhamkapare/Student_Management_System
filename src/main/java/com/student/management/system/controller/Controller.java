package com.student.management.system.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.student.management.system.entity.Student;
import com.student.management.system.entity.User;
import com.student.management.system.service.StudentService;
import com.student.management.system.service.UserService;

import jakarta.servlet.http.HttpSession;


@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	private StudentService studentservice;
	
	@Autowired
	private UserService user_service;
	
	@GetMapping("/")
	public String home()
	{
	    return "redirect:/login";
	}
	@GetMapping("/login")
	public String getLoginPage()
	{
		return "Login.html";
	}
	@GetMapping("/register")
	public String getRegisterPage()
	{
		return "Register.html";
	}
	@PostMapping("/register1")
	public String saveUser(@ModelAttribute User user)
	{
		user_service.saveUser(user);
		return "redirect:/login";
	}
	@PostMapping("/login")
	public String login(@RequestParam String username,@RequestParam String password,Model model,HttpSession session)
	
	{		
		
		User user=user_service.findByUsernameAndPassword(username,password);
		if(user!=null)
		{
			session.setAttribute("User", user);
			return "redirect:/students";
		}
		else
		{
			model.addAttribute("error","Invalid Username or Password");
			return "redirect:/login";
		}
	}
	@GetMapping("/students")
	public String findByUserUid(Model model,HttpSession session)
	{
		User loggedUser=(User)session.getAttribute("User");
		model.addAttribute("user",loggedUser);
		model.addAttribute("students",studentservice.findByUserUid(loggedUser.getUid()));
		return "Students.html";
	}
//	@GetMapping("/students/new")
//	public String createStudentForm(Model model)
//	{
////		Student student=new Student();
////		model.addAttribute("student",student);
//		return "create-student";
//	}
	@GetMapping("/students/new")
	public String createStudentForm(Model model, HttpSession session)
	{
	    User loggedUser = (User) session.getAttribute("User");

	    if (loggedUser == null) {
	        return "redirect:/login";
	    }

	    Student student = new Student();
	    model.addAttribute("student", student);

	    return "create-student";
	}
//	@PostMapping("/stu")
//	public String saveStudent(@ModelAttribute Student student,HttpSession session)
//	{
//		User user=(User)session.getAttribute("User");
//		student.setUser(user);
//		studentservice.saveStudent(student);
//		return "redirect:/students";
//	}
	
	@PostMapping("/stu")
	public String saveStudent(@ModelAttribute Student student, HttpSession session)
	{
	    User user = (User) session.getAttribute("User");

	    if (user == null) {
	        return "redirect:/login";
	    }

	    student.setUser(user);
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
