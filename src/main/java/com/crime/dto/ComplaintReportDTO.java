package com.crime.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ComplaintReportDTO extends ReportDTO {

	private static final long serialVersionUID = 3159749948400449023L;

	private String complaintNumber;
}
