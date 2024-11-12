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

import com.crime.dto.CaseeDTO;
import com.crime.dto.SuccessResponse;
import com.crime.service.ICaseService;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/case")
public class CaseController {

	private final ICaseService caseService;

	@Operation(summary = "Add Case", description = "Add Case details")
	@ApiResponses({
			@ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE), responseCode = "201", description = "Case created successfully") })
	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Hidden
	public ResponseEntity<SuccessResponse> addCase(@RequestBody CaseeDTO CaseeDTO) {
		return caseService.addCase(CaseeDTO);
	}

	@Operation(summary = "Update Case", description = "Update Case")
	@ApiResponses({
			@ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE), responseCode = "200", description = "Case updated successfully") })
	@PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SuccessResponse> updateCase(@RequestBody CaseeDTO caseeDTO) {
		return caseService.updateCase(caseeDTO);
	}

	@Operation(summary = "Fetch Case details", description = "Fetch Case details")
	@ApiResponses({
			@ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE), responseCode = "200") })
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CaseeDTO> getCaseDetailsById(@PathVariable("id") long caseId) {
		return caseService.fetchCaseDetails(caseId);
	}

	@Operation(summary = "Delete Case", description = "Delete Case")
	@ApiResponses({
			@ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE), responseCode = "200", description = "Case deleted successfully") })
	@DeleteMapping(value = "/delete/{caseId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SuccessResponse> deleteCase(@PathVariable("caseId") long caseId) {
		return caseService.deleteCase(caseId);
	}

}
