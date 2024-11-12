package com.crime.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseDTO implements Serializable {

	private static final long serialVersionUID = -5047053970728864781L;

	private long id;

	@Hidden
	private LocalDateTime createdDate;

	@Hidden
	private LocalDateTime updatedDate;

}
