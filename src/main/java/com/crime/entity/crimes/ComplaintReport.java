package com.crime.entity.crimes;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "tb_complaint_report")
@DynamicInsert
@DynamicUpdate
public class ComplaintReport extends Report {

	private static final long serialVersionUID = 1424633504785974721L;

	@Column(name = "complaint_number")
	private String complaintNumber;

}
