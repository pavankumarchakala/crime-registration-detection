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
public class StationDTO extends BaseDTO {

	private static final long serialVersionUID = 1952252843504465338L;

	public String name;

	public String code;

	public String phone;

	public String email;

	public AddressDTO address;

	public DepartmentDTO department;
}
