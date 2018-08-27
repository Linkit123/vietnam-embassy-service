package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;

@Service
public interface StudentService {
	List<Student> findAllStudent();
	Student findStudentById(int id);
	void updateStudent(Student student);
	void deleteStudent(int id);
	boolean addStudent(Student student);
	boolean studentExists(String name, String address, String age);
//	Set<Student> addRegister(Student student, Set<Course> courses);
}
