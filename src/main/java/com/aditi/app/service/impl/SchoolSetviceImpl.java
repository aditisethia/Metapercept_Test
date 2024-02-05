package com.aditi.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aditi.app.model.School;
import com.aditi.app.repo.SchoolRepo;
import com.aditi.app.service.ISchoolService;

@Service
public class SchoolSetviceImpl implements ISchoolService {

	@Autowired
	private SchoolRepo schoolRepo;
	
	@Override
	public ResponseEntity<?> addSchoolServoce(School school) {
		School savedSchool = schoolRepo.save(school);
		return new ResponseEntity<>(savedSchool,HttpStatus.ACCEPTED);
	}

}

