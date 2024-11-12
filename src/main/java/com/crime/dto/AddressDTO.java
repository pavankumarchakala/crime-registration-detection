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
public class AddressDTO extends BaseDTO {

	private static final long serialVersionUID = -692372898332985361L;

	private String doorNumber;

	private String streetName;

	private String district;

	private String state;

	private String country;

	private String pincode;

	private String landmark;

}
