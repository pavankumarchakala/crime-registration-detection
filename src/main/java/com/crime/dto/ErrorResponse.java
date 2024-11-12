package com.crime.dto;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class ErrorResponse implements Serializable {

	private static final long serialVersionUID = 6835423663185072379L;

	private String message;

	private HttpStatus status;

}
