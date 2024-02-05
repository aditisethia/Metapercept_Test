package com.aditi.app.service;

import org.springframework.http.ResponseEntity;

import com.aditi.app.model.ClassModel;

public interface IClassService {

	ResponseEntity<?> addClass(ClassModel classModel);

	ResponseEntity<?> getAllClasses();

	ResponseEntity<?> updateClass(ClassModel classModel);

	ResponseEntity<?> getClassById(Long id);

	ResponseEntity<?> deleteClassById(Long id);

}
