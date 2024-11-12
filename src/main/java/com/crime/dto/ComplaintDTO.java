package com.crime.dto;

import java.time.LocalDateTime;

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
public class ComplaintDTO extends BaseDTO {

	private static final long serialVersionUID = -6042862586393007669L;

	private String number;

	private DepartmentDTO department;

	private StationUserDTO registeredBy;

	private ComplaintUserDTO handledBy;

	private LocalDateTime registeredDate;

	private CaseStatusDTO caseStatus;

	private AddressDTO registeredAddress;
}
