package com.crime.entity.crimes;

import java.time.LocalDateTime;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.crime.entity.BaseEntity;
import com.crime.entity.users.Address;
import com.crime.entity.users.ComplaintUser;
import com.crime.entity.users.StationUser;

import jakarta.persistence.Column;
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
@Table(name = "tb_complaint")
@DynamicInsert
@DynamicUpdate
public class Complaint extends BaseEntity {

	private static final long serialVersionUID = 3428772832537542377L;

	private String number;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

	@ManyToOne
	@JoinColumn(name = "station_user_id")
	private StationUser registeredBy;

	@ManyToOne
	@JoinColumn(name = "complaint_user_id")
	private ComplaintUser handledBy;

	@Column(name = "registered_date")
	private LocalDateTime registeredDate;

	@ManyToOne
	@JoinColumn(name = "status")
	private CaseStatus caseStatus;

	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address registeredAddress;

}
