package com.matrix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.matrix.model.Semester;
import com.matrix.repository.SemesterRepository;

@Service
public class SemesterService extends AbstractService<Semester>{
	
	@Autowired
	private SemesterRepository repository;

	@Override
	protected JpaRepository<Semester, Long> getRepository() {
		return repository;
	}
	

}
