package com.crime.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ClosingReportDTO extends ReportDTO {

	private static final long serialVersionUID = 2986886799705590689L;

	public CaseeDTO casee;
}
