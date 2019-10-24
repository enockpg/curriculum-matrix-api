package com.matrix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matrix.model.Matrix;

public interface MatrixRepository extends JpaRepository<Matrix, Long> { }
