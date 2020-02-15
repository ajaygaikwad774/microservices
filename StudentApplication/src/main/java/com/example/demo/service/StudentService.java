package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.respository.StudentRepository;

@Service
@Transactional
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public Student createStudent(Student student){
		 
		return studentRepository.save(student);
	}
	
	
	public List<Student> createManyStudent(List<Student> student){
		return studentRepository.saveAll(student);	
	}

	public Student updateStudent(Student student){
		return studentRepository.save(student);
	}

	public void deleteStudentById(Long id) {
		Optional<Student> stud = studentRepository.findById(id);
		if (!stud.isPresent()) {
			throw new UserNotFoundException("user is not present - "+id);
		} else {
			studentRepository.deleteById(id);
		}
	}

	public void deleteAllStudent() {	
		studentRepository.deleteAll();		
	}

	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	public Optional<Student> getStudent(Long id) {
		Optional<Student> stud = studentRepository.findById(id);
		if (!stud.isPresent()) {
			throw new UserNotFoundException("id is not present - "+id);
		}else{
			return stud;	
		}	
	}

}
