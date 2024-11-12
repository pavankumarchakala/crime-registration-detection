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
public class StationUserDTO extends BaseDTO {

	private static final long serialVersionUID = 8602186643115736506L;

	public String userName;

	public String password;

	public String badgeId;

	public String firstName;

	public String lastName;

	public String phone;

	public String email;

	public AddressDTO address;

	public DepartmentDTO department;

	public StationDTO station;
}
