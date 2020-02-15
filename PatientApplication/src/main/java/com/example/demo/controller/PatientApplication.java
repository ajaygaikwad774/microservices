package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientApplication {


	@GetMapping(path = "/patient")
	public String helloPatient(){
		return "hie! you have assigned a doctor ebuto";
	}

	
}
