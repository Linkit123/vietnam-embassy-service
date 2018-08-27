package com.example.demo.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="student_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int studentId;
	
	@Column(name="student_name")
	private String studentName;
	
	@Column(name="student_address")
	private String studentAddress;
	
	@Column(name="student_age")
	private String studentAge;
	
	@OneToMany(mappedBy="",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<RegisterCourse> registerCourses;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	public String getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(String studentAge) {
		this.studentAge = studentAge;
	}
	public Set<RegisterCourse> getRegisterCourses() {
		return registerCourses;
	}
	public void setRegisterCourses(Set<RegisterCourse> registerCourses) {
		this.registerCourses = registerCourses;
	}
	
}
