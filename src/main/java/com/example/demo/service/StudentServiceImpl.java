package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentDAO;
import com.example.demo.entity.Student;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	public List<Student> findAllStudent() {
		// TODO Auto-generated method stub
		if(studentDAO.findAll()==null) {
			System.out.println("Khong co sinh vien nao trong danh sach!");
		}
		return studentDAO.findAll();
	}

	@Override
	public Student findStudentById(int id) {
		// TODO Auto-generated method stub
		return studentDAO.getOne(id);
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		Student student2 = new Student();
		student2.setStudentName(student.getStudentName());
		student2.setStudentAddress(student.getStudentAddress());
		student2.setStudentAge(student.getStudentAge());
		studentDAO.save(student2);
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		studentDAO.delete(findStudentById(id));
	}

	@Override
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		if (studentExists(student.getStudentName(), student.getStudentAddress(), student.getStudentAge())) {
			return false;
		}else {
			studentDAO.save(student);
			return true;
		}
	}

	@PersistenceContext 
	private EntityManager entitymanager;
	
	@Override
	public boolean studentExists(String name, String address, String age) {
		// TODO Auto-generated method stub
		String sql = "FROM Student as std WHERE std.student_name=? and std.student_address=? and std.student_age=?";
		int count = entitymanager.createQuery(sql).setParameter(1, name)
				.setParameter(2, address).setParameter(3, age).getResultList().size();
		return count>0?true:false;
	}
}
