package com.crime.service;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crime.dao.crimes.IComplaintRepository;
import com.crime.dto.ComplaintDTO;
import com.crime.dto.SuccessResponse;
import com.crime.entity.crimes.Complaint;
import com.crime.exceptions.ApplicationException;
import com.crime.util.RandomUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComplaintService implements IComplaintService {

	private final IComplaintRepository complaintRepository;

	private final ModelMapper modelMapper;

	@Override
	@Transactional
	public ResponseEntity<SuccessResponse> addComplaint(ComplaintDTO complainteDTO) {
		complainteDTO.setNumber(RandomUtils.getRandomString());
		Complaint complainte = modelMapper.map(complainteDTO, Complaint.class);
		Complaint savedComplaint = complaintRepository.save(complainte);
		return ResponseEntity.ok(SuccessResponse.builder().savedItemId(savedComplaint.getId())
				.status(HttpStatus.CREATED).message("Complaint Created Successfully !!").build());
	}

	@Override
	@Transactional
	public ResponseEntity<SuccessResponse> updateComplaint(ComplaintDTO complainteDTO) {
		Complaint complainte = complaintRepository.findById(complainteDTO.getId())
				.orElseThrow(() -> ApplicationException.builder().httpStatus(HttpStatus.NOT_FOUND)
						.message("No Complaint found !!").build());
		modelMapper.map(complainteDTO, complainte);
		return ResponseEntity.ok(SuccessResponse.builder().savedItemId(complainteDTO.getId()).status(HttpStatus.OK)
				.message("Complaint Updated Successfully !!").build());
	}

	@Override
	public ResponseEntity<ComplaintDTO> fetchComplaintDetails(long complaintId) {
		Complaint complainte = complaintRepository.findById(complaintId).orElseThrow(() -> ApplicationException
				.builder().httpStatus(HttpStatus.NOT_FOUND).message("No Complaint found !!").build());
		return ResponseEntity.ok(modelMapper.map(complainte, ComplaintDTO.class));
	}

	@Override
	@Transactional
	public ResponseEntity<SuccessResponse> deleteComplaint(long complaintId) {
		complaintRepository.deleteById(complaintId);
		return ResponseEntity.ok(
				SuccessResponse.builder().status(HttpStatus.OK).message("Complaint Deleted Successfully !!").build());
	}

}
