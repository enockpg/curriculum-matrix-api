package com.matrix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.matrix.model.Matrix;
import com.matrix.repository.MatrixRepository;

@Service
public class MatrixService extends AbstractService<Matrix>{

	@Autowired
	private MatrixRepository repository;
	
	@Override
	protected JpaRepository<Matrix, Long> getRepository() {
		return repository;
	}

}
