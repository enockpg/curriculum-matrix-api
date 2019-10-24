package com.matrix.model.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matrix.model.Discipline;
import com.matrix.repository.DisciplineRepository;

public class DisciplineService extends AbstractService<Discipline>{

	private DisciplineRepository repository;
	
	@Override
	protected JpaRepository<Discipline, Long> getRepository() {
		return repository;
	}

}
