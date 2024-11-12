package com.crime.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crime.dto.DepartmentDTO;
import com.crime.dto.SuccessResponse;
import com.crime.service.IDepartmentService;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {

	private final IDepartmentService departmentService;

	@Operation(summary = "Add Department", description = "Add Department details")
	@ApiResponses({
			@ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE), responseCode = "201", description = "Department created successfully") })
	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Hidden
	public ResponseEntity<SuccessResponse> addDepartment(@RequestBody DepartmentDTO departmentDTO) {
		return departmentService.addDepartment(departmentDTO);
	}

	@Operation(summary = "Update Department", description = "Update Department")
	@ApiResponses({
			@ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE), responseCode = "200", description = "Department updated successfully") })
	@PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SuccessResponse> updateDepartment(@RequestBody DepartmentDTO departmentDTO) {
		return departmentService.updateDepartment(departmentDTO);
	}

	@Operation(summary = "Fetch Department details", description = "Fetch Department details")
	@ApiResponses({
			@ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE), responseCode = "200") })
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DepartmentDTO> getDepartmentDetailsById(@PathVariable("id") long departmentId) {
		return departmentService.fetchDepartmentDetails(departmentId);
	}

	@Operation(summary = "Delete Department", description = "Delete Department")
	@ApiResponses({
			@ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE), responseCode = "200", description = "Department deleted successfully") })
	@DeleteMapping(value = "/delete/{departmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SuccessResponse> deleteUser(@PathVariable("departmentId") long departmentId) {
		return departmentService.deleteDepartment(departmentId);
	}

}
