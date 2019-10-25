package com.matrix.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Professor extends AbstractModel<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4378017643956260174L;

	@NotBlank
	@Length(min = 5, max = 80)
	@Column(nullable = false, length = 120)
	private String name;

}
