package com.matrix.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Discipline extends AbstractModel<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2279869692535224462L;

	/** value of discipline */
	@Column(nullable = false, name = "amount")
	private short amount;
	
	/**
	 * more than one subject per teacher and more than one teacher per subject
	 */
	@ManyToMany(fetch=FetchType.LAZY)
	private List<Professor> professors;
	
	@NotBlank
	@Length(min = 5, max = 120)
	@Column(nullable = false, length = 300)
	private String syllabus;
	
	@Lob
	@NotBlank
	@Size(min = 10)
	@Type(type = "org.hibernate.type.TextType")
	@Column(nullable = false)
	private String program;
	
	@Lob
	@NotBlank
	@Size(min = 10)
	@Type(type = "org.hibernate.type.TextType")
	@Column(nullable = false)
	private String bibiography;
	
	@JsonIgnoreProperties({ "semesters" })
	@NotNull
	@ManyToOne
	@JoinColumn(name = "semester_id", nullable = false)
	private Semester semester;

}
