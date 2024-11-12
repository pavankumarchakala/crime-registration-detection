package com.crime.service;

import org.springframework.http.ResponseEntity;

import com.crime.dto.DepartmentDTO;
import com.crime.dto.SuccessResponse;

public interface IDepartmentService {

	ResponseEntity<SuccessResponse> addDepartment(DepartmentDTO departmentDTO);

	ResponseEntity<SuccessResponse> updateDepartment(DepartmentDTO departmentDTO);

	ResponseEntity<DepartmentDTO> fetchDepartmentDetails(long departmentId);

	ResponseEntity<SuccessResponse> deleteDepartment(long departmentId);
}
