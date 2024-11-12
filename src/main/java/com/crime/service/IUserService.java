package com.crime.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.crime.dto.StationUserDTO;
import com.crime.dto.SuccessResponse;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public interface IUserService {

	ResponseEntity<StationUserDTO> addUser(@Valid @NotNull @NotEmpty StationUserDTO userDTO,
			@Valid @NotNull @NotEmpty MultipartFile[] files);

	ResponseEntity<SuccessResponse> login(StationUserDTO userDTO);

	ResponseEntity<StationUserDTO> findUserById(long id);

	ResponseEntity<StationUserDTO> findUserByBadgeId(String badgeId);

}
