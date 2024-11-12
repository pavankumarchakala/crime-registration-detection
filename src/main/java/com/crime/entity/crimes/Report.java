package com.crime.entity.crimes;

import com.crime.entity.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;

@MappedSuperclass
public class Report extends BaseEntity {

	private static final long serialVersionUID = 1871460742181926601L;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "case_id", referencedColumnName = "id")
	private Casee casee;

	@Column(name = "case_number")
	private String caseNumber;

}
