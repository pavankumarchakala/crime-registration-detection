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

import com.crime.dto.StationDTO;
import com.crime.dto.SuccessResponse;
import com.crime.service.IStationService;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/station")
public class StationController {

	private final IStationService stationService;

	@Operation(summary = "Add Station", description = "Add Station details")
	@ApiResponses({
			@ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE), responseCode = "201", description = "Station created successfully") })
	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Hidden
	public ResponseEntity<SuccessResponse> addStation(@RequestBody StationDTO stationDTO) {
		return stationService.addStation(stationDTO);
	}

	@Operation(summary = "Update Station", description = "Update Station")
	@ApiResponses({
			@ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE), responseCode = "200", description = "Station updated successfully") })
	@PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SuccessResponse> updateStation(@RequestBody StationDTO stationDTO) {
		return stationService.updateStation(stationDTO);
	}

	@Operation(summary = "Fetch Station details", description = "Fetch Station details")
	@ApiResponses({
			@ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE), responseCode = "200") })
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StationDTO> getStationDetailsById(@PathVariable("id") long stationId) {
		return stationService.fetchStationDetails(stationId);
	}

	@Operation(summary = "Delete Station", description = "Delete Station")
	@ApiResponses({
			@ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE), responseCode = "200", description = "Station deleted successfully") })
	@DeleteMapping(value = "/delete/{stationId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SuccessResponse> deleteUser(@PathVariable("stationId") long stationId) {
		return stationService.deleteStation(stationId);
	}

}
