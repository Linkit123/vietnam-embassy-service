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
@Table(name="course")
public class Course implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int courseId;
	
	@Column(name="course_name")
	private String courseName;
	
	@OneToMany(mappedBy="",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<RegisterCourse> registerCourse;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Set<RegisterCourse> getRegisterCourse() {
		return registerCourse;
	}

	public void setRegisterCourse(Set<RegisterCourse> registerCourse) {
		this.registerCourse = registerCourse;
	}
	
}
