package com.matrix.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Semester extends AbstractModel<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5768485927198979675L;

	@Column(nullable = false, name = "period")
	private short period;
	
	@OneToMany(mappedBy = "semester")
	private List<Discipline> disciplines;

}
