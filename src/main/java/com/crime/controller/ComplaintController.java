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

import com.crime.dto.ComplaintDTO;
import com.crime.dto.SuccessResponse;
import com.crime.service.IComplaintService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/complaint")
public class ComplaintController {

	private final IComplaintService complaintService;

	@Operation(summary = "Add Complaint", description = "Add Complaint details")
	@ApiResponses({
			@ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE), responseCode = "201", description = "Complaint created successfully") })
	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SuccessResponse> addComplaint(@RequestBody ComplaintDTO complaintDTO) {
		return complaintService.addComplaint(complaintDTO);
	}

	@Operation(summary = "Update Complaint", description = "Update Complaint")
	@ApiResponses({
			@ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE), responseCode = "200", description = "Complaint updated successfully") })
	@PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SuccessResponse> updateComplaint(@RequestBody ComplaintDTO complaintDTO) {
		return complaintService.updateComplaint(complaintDTO);
	}

	@Operation(summary = "Fetch Complaint details", description = "Fetch Complaint details")
	@ApiResponses({
			@ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE), responseCode = "200") })
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ComplaintDTO> getComplaintDetailsById(@PathVariable("id") long complaintId) {
		return complaintService.fetchComplaintDetails(complaintId);
	}

	@Operation(summary = "Delete Complaint", description = "Delete Complaint")
	@ApiResponses({
			@ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE), responseCode = "200", description = "Complaint deleted successfully") })
	@DeleteMapping(value = "/delete/{complaintId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SuccessResponse> deleteUser(@PathVariable("complaintId") long complaintId) {
		return complaintService.deleteComplaint(complaintId);
	}

}
