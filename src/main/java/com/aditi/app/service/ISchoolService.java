package com.aditi.app.service;

import org.springframework.http.ResponseEntity;

import com.aditi.app.model.School;

public interface ISchoolService {

	ResponseEntity<?> addSchoolServoce(School school);

}
