package com.matrix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.matrix.model.Professor;
import com.matrix.repository.ProfessorRepository;

@Service
public class ProfessorService extends AbstractService<Professor>{

	@Autowired
	private ProfessorRepository repository; 
	
	@Override
	protected JpaRepository<Professor, Long> getRepository() {
		return repository;
	}

}