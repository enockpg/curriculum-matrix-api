package com.matrix.model.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matrix.model.Matrix;
import com.matrix.repository.MatrixRepository;

public class MatrixService extends AbstractService<Matrix>{

	private MatrixRepository repository;
	
	@Override
	protected JpaRepository<Matrix, Long> getRepository() {
		return repository;
	}

}
