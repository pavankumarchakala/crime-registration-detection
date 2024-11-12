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
public class ReportDTO extends BaseDTO {

	private static final long serialVersionUID = 1749919618423329921L;

	private CaseeDTO casee;

	private String caseNumber;
}
