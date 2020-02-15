package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
public class Courses {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull(message = "course shuold not be empty")
	private String courseName;

	/*
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Student> student = new ArrayList<Student>();
	 */
   /* 
	@ManyToOne(fetch = FetchType.LAZY)	
	private Student student;

	public Student getStudent()   {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}*/

	public Courses() {
		// TODO Auto-generated constructor stub
	}

	/*
	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}
	 */

	public Courses(Long id, @NotNull(message = "course shuold not be empty") String courseName) {
		this.id = id;
		this.courseName = courseName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Override
	public String toString() {
		return "Courses [id=" + id + ", courseName=" + courseName + "]";
	}



}
