package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@Entity
//@JsonIgnoreProperties(value = { "field1", "field2" })
@DynamicInsert
@DynamicUpdate
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull(message = "name should not be null")
	@Size(min = 2, max = 30, message = "name must be between 2 to 30 ")
	private String name;

	@Min(value = 5, message = "Age should not be less than 5")
	@Max(value = 22, message = "Age should not be greater than 22")
	private int age;

	@Pattern(regexp = ".+@.+\\.[a-z]+", message = "invalid format")
	@Email(message = "email should be valid")
	@NotNull(message = "email should not be null")
	@Size(max = 100)
	@Column(unique = true)
	private String email;

	/* @OneToOne(cascade = CascadeType.ALL)
	private Passport passport;
    */
	
   /*
	@OneToMany(cascade = CascadeType.ALL)
	private List<Courses> courses = new ArrayList<>();
   */
   
	/*
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "students_courses",
    joinColumns = {
            @JoinColumn(name = "student_id", referencedColumnName = "id",
                    nullable = false, updatable = false)},
    inverseJoinColumns = {
            @JoinColumn(name = "course_id", referencedColumnName = "id",
                    nullable = false, updatable = false)})
    private List<Courses> courses = new ArrayList<>(); */

	/*
	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	} */
  /*
	public List<Courses> getCourses() {
		return courses;
	}

	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}
  */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public Student() {
	}

	public Student(Long id,
			@NotNull(message = "name should not be null") @Size(min = 2, max = 30, message = "name must be between 2 to 30 ") String name,
			@Min(value = 5, message = "Age should not be less than 5") @Max(value = 22, message = "Age should not be greater than 22") int age,
			@Pattern(regexp = ".+@.+\\.[a-z]+", message = "invalid format") @Email(message = "email should be valid") @NotNull(message = "email should not be null") String email) {

		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + "]";
	}


}
