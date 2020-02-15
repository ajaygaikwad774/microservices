package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@DynamicInsert
@DynamicUpdate
public class Passport {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String number;
	
//	@OneToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
//	private Student student;

	public Passport() {
		// TODO Auto-generated constructor stub
	}
	
	public Passport(Long id, String number) {
		this.id = id;
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

//	public Student getStudent() {
//		return student;
//	}

//	public void setStudent(Student student) {
//		this.student = student;
//	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", number=" + number + "]";
	}
	
	
}
