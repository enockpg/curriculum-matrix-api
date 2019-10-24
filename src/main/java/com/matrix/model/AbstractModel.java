package com.matrix.model;
/**
 * Create adstract model for use on generic abstratoins 
 * @author enock pinheiro
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("hiding")
@Getter
@Setter
@EqualsAndHashCode
@MappedSuperclass
public abstract class AbstractModel<Long extends Serializable> implements Serializable {
	
	private static final long serialVersionUID = -4411902541807558237L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long id;

}
