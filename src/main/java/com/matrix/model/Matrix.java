package com.matrix.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Matrix extends AbstractModel<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5768485927198979675L;

	@Column(nullable = false, name = "year")
	private short year;

	/**
	 * I can change the year and repeat the semesters
	 */
	@ManyToMany(fetch=FetchType.LAZY)
	private List<Semester> semesters;
	
	@NotBlank
	@Length(min = 5, max = 80)
	@Column(nullable = false, length = 120)
	private String course;

}
