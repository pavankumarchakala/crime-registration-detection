package com.crime.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.crime.dto.StationUserDTO;
import com.crime.dto.SuccessResponse;
import com.crime.service.IUserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

	private final IUserService userService;

	@Operation(summary = "Register User", description = "Register User")
	@ApiResponses({
			@ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE), responseCode = "201", description = "User Registration is successful !!!") })
	@PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StationUserDTO> addUser(@Valid @NotNull @NotEmpty @RequestBody StationUserDTO userDTO,
			@RequestPart("files") @Valid @NotNull @NotEmpty MultipartFile[] files) {
		return userService.addUser(userDTO, files);
	}

	@Operation(summary = "Login", description = "Login")
	@ApiResponses({
			@ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE), responseCode = "200", description = "Logged in successful !!!") })
	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SuccessResponse> login(@RequestBody StationUserDTO userDTO) {
		return userService.login(userDTO);
	}

	@Operation(summary = "Find User By ID", description = "Find User By ID")
	@ApiResponses({
			@ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE), responseCode = "201", description = "Find User By ID !!!") })
	@GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StationUserDTO> findUserById(@PathVariable long id) {
		return userService.findUserById(id);
	}

	@Operation(summary = "Find User By Badge ID", description = "Find User By Badge ID")
	@ApiResponses({
			@ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE), responseCode = "201", description = "Find User By Badge ID !!!") })
	@GetMapping(value = "/{badgeId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StationUserDTO> findUserByBadgeId(@PathVariable String badgeId) {
		return userService.findUserByBadgeId(badgeId);
	}
}
