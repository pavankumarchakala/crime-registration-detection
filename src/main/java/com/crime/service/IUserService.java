package com.crime.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.crime.dto.StationUserDTO;
import com.crime.dto.SuccessResponse;

public interface IUserService {

	ResponseEntity<StationUserDTO> addUser(StationUserDTO userDTO, MultipartFile[] files);

	ResponseEntity<SuccessResponse> login(StationUserDTO userDTO);

	ResponseEntity<StationUserDTO> findUserById(long id);

	ResponseEntity<StationUserDTO> findUserByBadgeId(String badgeId);

}
