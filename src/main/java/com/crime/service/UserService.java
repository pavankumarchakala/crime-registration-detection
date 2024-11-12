package com.crime.service;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import com.crime.dao.crimes.IUserRepository;
import com.crime.dto.StationUserDTO;
import com.crime.dto.SuccessResponse;
import com.crime.entity.crimes.StationUser;
import com.crime.enums.EntityName;
import com.crime.exceptions.ApplicationException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

	private final IUserRepository userRepository;

	private final IMediaFilesUploadService mediaFilesUploadService;

	private final ModelMapper modelMapper;

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	@Transactional
	public ResponseEntity<StationUserDTO> addUser(StationUserDTO userDTO, MultipartFile[] files) {
		StationUser user = modelMapper.map(userDTO, StationUser.class);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		StationUser savedUser = userRepository.save(user);

		if (!ObjectUtils.isEmpty(files))
			mediaFilesUploadService.addMediaFiles(files, EntityName.DEPARTMENT_USER, savedUser.getId());

		userDTO.setId(savedUser.getId());
		userDTO.setCreatedDate(savedUser.getCreatedDate());
		userDTO.setUpdatedDate(savedUser.getUpdatedDate());
		return ResponseEntity.ok(userDTO);
	}

	@Override
	public ResponseEntity<SuccessResponse> login(StationUserDTO userDTO) {

		userRepository
				.findByUserNameAndPassword(userDTO.getUserName(), bCryptPasswordEncoder.encode(userDTO.getPassword()))
				.orElseThrow(() -> ApplicationException.builder().httpStatus(HttpStatus.NOT_FOUND)
						.message("No user found !! Please register first.").build());

		return ResponseEntity
				.ok(SuccessResponse.builder().message("Successfully logged in !!").status(HttpStatus.OK).build());
	}

	@Override
	public ResponseEntity<StationUserDTO> findUserById(long id) {
		StationUser user = userRepository.findById(id).orElseThrow(() -> ApplicationException.builder()
				.httpStatus(HttpStatus.NOT_FOUND).message("No user found !!").build());

		return ResponseEntity.ok(modelMapper.map(user, StationUserDTO.class));
	}

	@Override
	public ResponseEntity<StationUserDTO> findUserByBadgeId(String badgeId) {
		StationUser user = userRepository.findByBadgeId(badgeId).orElseThrow(() -> ApplicationException.builder()
				.httpStatus(HttpStatus.NOT_FOUND).message("No user found !!").build());

		return ResponseEntity.ok(modelMapper.map(user, StationUserDTO.class));
	}

}
