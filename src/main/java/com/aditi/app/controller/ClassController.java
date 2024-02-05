package com.aditi.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aditi.app.model.ClassModel;
import com.aditi.app.service.IClassService;

@RestController
@RequestMapping("/class")
public class ClassController {
	
	@Autowired
	private IClassService classService;

	@PostMapping("/addClass")
	public ResponseEntity<?> addClass(@RequestBody ClassModel classModel){
		return classService.addClass(classModel);
	}
	
	@GetMapping("/getAllClasses")
	public ResponseEntity<?> getAllClasses(){
		return classService.getAllClasses();
	}
	
	@GetMapping("/getClass")
	public ResponseEntity<?> getClassById(@RequestParam("id") Long id){
		return classService.getClassById(id);
	}
	
	@PutMapping("/updateClass")
	public ResponseEntity<?> updateClassById(@RequestBody ClassModel classModel){
		return classService.updateClass(classModel);
	}
	
	@DeleteMapping("/deleteClass")
	public ResponseEntity<?> deleteClassById(@RequestParam("id") Long id){
		return classService.deleteClassById(id);
	}
}
