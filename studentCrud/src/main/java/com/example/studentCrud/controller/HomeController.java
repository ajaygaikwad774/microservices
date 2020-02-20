package com.example.studentCrud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.studentCrud.model.User;
import com.example.studentCrud.service.UserService;

@RestController
// optional @RequestMapping("/api")
public class HomeController {

	@Autowired
	UserService userService;

	// @RequestMapping(value="/user/save",headers="Accept=application/json",method=RequestMethod.POST)

	@RequestMapping(value="/get",method = RequestMethod.GET)
	public ModelAndView hello(){
		 ModelAndView model = new ModelAndView();
		  
		  model.setViewName("user");
		  
		  return model;
		
		//return new ModelAndView("redirect:/user.html");
	}
	
	
	
	@PostMapping(value = "/user/save", headers = "Accept=application/json")
	public User addUser(@Valid @RequestBody User user) {
		System.out.println("Creating User...... " + user.getFirstName() + " " + user.getLastName());
		return userService.createUser(user);
	}

	@GetMapping(value = "/user/all", headers = "Accept=application/json")
	public List<User> getUser() {
		System.out.println(this.getClass().getSimpleName() + " - Get all employees service is invoked.");
		return (List<User>) userService.getUser();
	}

	@GetMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> findById(@PathVariable("id") Long id) {
		System.out.println("Fetching user with id " + id);
		User user = userService.findById(id);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
	}

	@DeleteMapping(value = "/user/deleteAll", headers = "Accept=application/json")
	public void deleteUserAll() {
		System.out.println(this.getClass().getSimpleName() + " - Delete all employees is invoked.");
		userService.deleteUserAll();
	}

	@DeleteMapping(value = "/user/delete/{id}", headers = "Accept=application/json")
	public ResponseEntity<Void> deleteUserById(@PathVariable() Long id) {
		User user = userService.findById(id);
		if (user == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			userService.deleteUserById(id);
			System.out.println(this.getClass().getSimpleName() + "- Delete employee by id is invoked." + id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}

	}

	@PutMapping(value = "/user/update/{id}", headers = "Accept=application/json")
	public ResponseEntity<User> update(@RequestBody User currentUser, @PathVariable("id") Long id) {
		User user = userService.findById(id);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		} else {
			User usr = userService.update(currentUser, id);
			return new ResponseEntity<User>(usr, HttpStatus.ACCEPTED);
		}

	}

}
