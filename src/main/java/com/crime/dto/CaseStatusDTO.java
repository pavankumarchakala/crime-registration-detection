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
public class CaseStatusDTO extends BaseDTO {

	private static final long serialVersionUID = 1087283936931684022L;

	private String name;

	private String displayName;

}
