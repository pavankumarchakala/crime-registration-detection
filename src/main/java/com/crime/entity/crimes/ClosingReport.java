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
@Table(name = "tb_closing_report")
@DynamicInsert
@DynamicUpdate
public class ClosingReport extends Report {

	private static final long serialVersionUID = -8619256674632422928L;

	@ManyToOne
	@JoinColumn(name = "case_id")
	public Casee casee;

}
