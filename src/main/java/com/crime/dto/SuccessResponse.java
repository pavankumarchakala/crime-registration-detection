package com.crime.dto;

import java.io.Serializable;

import org.springframework.http.HttpStatusCode;

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
public class SuccessResponse implements Serializable {

	private static final long serialVersionUID = 3260080921833124416L;

	private String message;

	private HttpStatusCode status;

	private long savedItemId;

}
