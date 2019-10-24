package com.matrix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matrix.model.Semester;

public interface SemesterRepository extends JpaRepository<Semester, Long> { }
