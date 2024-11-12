package com.crime.entity.crimes;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Builder
@Entity
@Table(name = "tb_complete_case_report")
@DynamicInsert
@DynamicUpdate
public class CompleteCaseReport extends Report {

	private static final long serialVersionUID = 3871999002364568186L;

	@ManyToOne
	@JoinColumn(name = "case_id")
	public Casee casee;
}
