package com.crime.entity.crimes;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.crime.entity.BaseEntity;
import com.crime.entity.users.Address;
import com.crime.entity.users.ComplaintUser;
import com.crime.entity.users.StationUser;

import jakarta.persistence.CascadeType;
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
@Table(name = "tb_case")
@DynamicInsert
@DynamicUpdate
public class Casee extends BaseEntity {

	private static final long serialVersionUID = -3915107267864949913L;

	@Column(name = "number")
	private String number;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

	@ManyToOne
	@JoinColumn(name = "handled_by")
	private StationUser departmentUser;

	@ManyToOne
	@JoinColumn(name = "registered_by")
	private ComplaintUser complaintUser;

	@ManyToOne
	@JoinColumn(name = "status")
	private CaseStatus caseStatus;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "registered_address")
	public Address registeredAddress;

}
