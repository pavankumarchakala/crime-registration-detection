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
public class ComplaintUserDTO extends BaseDTO {

	private static final long serialVersionUID = 3230404275376009329L;

	public String firstName;

	public String lastName;

	public String phone;

	public String email;

	public AddressDTO address;
}
