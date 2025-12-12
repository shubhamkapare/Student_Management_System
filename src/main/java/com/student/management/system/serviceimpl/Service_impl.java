package com.student.management.system.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.management.system.entity.Student;
import com.student.management.system.repository.Student_Repository;
import com.student.management.system.service.StudentService;

@Service
public class Service_impl implements StudentService {

	@Autowired
	private Student_Repository studentreposotory;
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		List<Student> list = studentreposotory.findAll();
		return list;
	}
	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentreposotory.save(student);
	}
	@Override
	public Student getById(int id) {
		// TODO Auto-generated method stub
		return studentreposotory.findById(id).get();
	}
	@Override
	
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		studentreposotory.deleteById(id);
	}

}
