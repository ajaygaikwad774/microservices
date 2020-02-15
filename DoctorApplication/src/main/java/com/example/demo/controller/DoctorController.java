package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {

	@GetMapping(path = "/doctor")
	public String helloDoctor(){
		return "hie! i am doctor ebuto";
	}
}
