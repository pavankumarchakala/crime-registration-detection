package com.crime.service;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crime.dao.crimes.IDepartmentRepository;
import com.crime.dto.DepartmentDTO;
import com.crime.dto.SuccessResponse;
import com.crime.entity.crimes.Department;
import com.crime.exceptions.ApplicationException;
import com.crime.util.RandomUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentService implements IDepartmentService {

	private final IDepartmentRepository departmentRepository;

	private final ModelMapper modelMapper;

	@Override
	@Transactional
	public ResponseEntity<SuccessResponse> addDepartment(DepartmentDTO departmenteDTO) {
		departmenteDTO.setCode(RandomUtils.getRandomString());
		Department departmente = modelMapper.map(departmenteDTO, Department.class);
		Department savedDepartment = departmentRepository.save(departmente);
		return ResponseEntity.ok(SuccessResponse.builder().savedItemId(savedDepartment.getId())
				.status(HttpStatus.CREATED).message("Department Created Successfully !!").build());
	}

	@Override
	@Transactional
	public ResponseEntity<SuccessResponse> updateDepartment(DepartmentDTO departmenteDTO) {
		Department departmente = departmentRepository.findById(departmenteDTO.getId())
				.orElseThrow(() -> ApplicationException.builder().httpStatus(HttpStatus.NOT_FOUND)
						.message("No Department found !!").build());
		modelMapper.map(departmenteDTO, departmente);
		return ResponseEntity.ok(SuccessResponse.builder().savedItemId(departmenteDTO.getId()).status(HttpStatus.OK)
				.message("Department Updated Successfully !!").build());
	}

	@Override
	public ResponseEntity<DepartmentDTO> fetchDepartmentDetails(long departmentId) {
		Department departmente = departmentRepository.findById(departmentId).orElseThrow(() -> ApplicationException
				.builder().httpStatus(HttpStatus.NOT_FOUND).message("No Department found !!").build());
		return ResponseEntity.ok(modelMapper.map(departmente, DepartmentDTO.class));
	}

	@Override
	@Transactional
	public ResponseEntity<SuccessResponse> deleteDepartment(long departmentId) {
		departmentRepository.deleteById(departmentId);
		return ResponseEntity.ok(
				SuccessResponse.builder().status(HttpStatus.OK).message("Department Deleted Successfully !!").build());
	}

}
