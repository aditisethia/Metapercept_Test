package com.aditi.app.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aditi.app.model.ClassModel;
import com.aditi.app.repo.ClassRepo;
import com.aditi.app.service.IClassService;

@Service
public class ClassServiceImpl implements IClassService {

	@Autowired
	private ClassRepo classRepo;
	
	@Override
	public ResponseEntity<?> addClass(ClassModel classModel) {
		ClassModel save = classRepo.save(classModel);
		return new ResponseEntity<>(save,HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<?> getAllClasses() {
		List<ClassModel> classList = classRepo.findAll();
		return new ResponseEntity<>(classList,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> updateClass(ClassModel classModel) {
		Optional<ClassModel> classOpt = classRepo.findById(classModel.getId());
		if(classOpt.isPresent()) {
			ClassModel oldClassData = classOpt.get();
			if(Objects.nonNull(classModel.getSchool()))
				oldClassData.setSchool(classModel.getSchool());
			
			if(!classModel.getStudent().isEmpty())
				oldClassData.getStudent().addAll(classModel.getStudent());
			
			return new ResponseEntity<>(classOpt.get(),HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<?> getClassById(Long id) {
		Optional<ClassModel> classOpt = classRepo.findById(id);
		if(classOpt.isPresent()) {
			return new ResponseEntity<>(classOpt.get(),HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<?> deleteClassById(Long id) {
		Optional<ClassModel> classOpt = classRepo.findById(id);
		if(classOpt.isPresent()) {
			classRepo.delete(classOpt.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
