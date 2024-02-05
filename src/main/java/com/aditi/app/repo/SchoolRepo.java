package com.aditi.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aditi.app.model.School;

public interface SchoolRepo extends JpaRepository<School, Long>{

}
