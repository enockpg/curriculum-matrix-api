package com.matrix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matrix.model.Discipline;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> { }
