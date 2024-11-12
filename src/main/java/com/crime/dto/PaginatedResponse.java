package com.crime.dto;

import java.io.Serializable;
import java.util.List;

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
public class PaginatedResponse<T> implements Serializable {

	private static final long serialVersionUID = 1874495078749442376L;

	private List<T> list;

	private int currPageNum;

	private int totalPages;

	private int totalRecords;

}