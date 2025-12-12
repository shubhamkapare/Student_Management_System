package com.student.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.management.system.entity.Student;

@Repository
public interface Student_Repository extends JpaRepository<Student, Integer> {

}
