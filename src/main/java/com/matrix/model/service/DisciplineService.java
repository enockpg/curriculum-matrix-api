package com.matrix.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.matrix.model.Discipline;
import com.matrix.repository.DisciplineRepository;

@Service
public class DisciplineService extends AbstractService<Discipline>{

	@Autowired
	private DisciplineRepository repository;
	
	@Override
	protected JpaRepository<Discipline, Long> getRepository() {
		return repository;
	}

}
