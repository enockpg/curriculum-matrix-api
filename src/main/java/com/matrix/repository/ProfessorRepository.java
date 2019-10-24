package com.matrix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matrix.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> { }
