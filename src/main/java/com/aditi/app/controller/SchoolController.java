package com.aditi.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aditi.app.model.School;
import com.aditi.app.service.ISchoolService;

@RestController
@RequestMapping("/school")
public class SchoolController {
	
	@Autowired
	private ISchoolService schoolService;

	public ResponseEntity<?> addSchool(@RequestBody School school){
		return schoolService.addSchoolServoce(school);
	}
}
