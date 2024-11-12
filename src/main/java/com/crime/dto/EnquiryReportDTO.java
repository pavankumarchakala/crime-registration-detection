package com.crime.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class EnquiryReportDTO extends ReportDTO {

	private static final long serialVersionUID = -2835404313978692176L;

	public CaseeDTO casee;

}
