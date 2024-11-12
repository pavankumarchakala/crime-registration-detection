package com.crime.dto;

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
public class CaseeDTO extends BaseDTO {

	private static final long serialVersionUID = 9087112427147225584L;

	private String number;

	private DepartmentDTO department;

	private StationUserDTO stationUser;

	private ComplaintUserDTO complaintUser;

	private CaseStatusDTO caseStatus;

	public AddressDTO registeredAddress;
}
