package com.crime.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CompleteCaseReportDTO extends ReportDTO {

	private static final long serialVersionUID = 2469114594550524366L;

	public CaseeDTO casee;

}
