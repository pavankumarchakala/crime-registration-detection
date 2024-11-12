package com.crime.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = 3849807106163417698L;

	private HttpStatus httpStatus;

	private String message;

	public ApplicationException() {
		super();
	}

	public ApplicationException(Throwable t) {
		super(t);
	}

	public ApplicationException(String message) {
		super(message);
		this.message = message;
	}

	public ApplicationException(String message, HttpStatus status) {
		super(message);
		this.message = message;
		this.httpStatus = status;
	}

	public ApplicationException(String message, Throwable t) {
		super(message, t);
		this.message = message;
	}

	public ApplicationException(Throwable t, String message) {
		super(message, t);
		this.message = message;
	}

	public ApplicationException(HttpStatus status, String message) {
		super(message);
		this.message = message;
		this.httpStatus = status;
	}
}
