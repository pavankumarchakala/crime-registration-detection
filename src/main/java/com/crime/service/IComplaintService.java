package com.crime.service;

import org.springframework.http.ResponseEntity;

import com.crime.dto.ComplaintDTO;
import com.crime.dto.SuccessResponse;

public interface IComplaintService {

	ResponseEntity<SuccessResponse> addComplaint(ComplaintDTO complaintDTO);

	ResponseEntity<SuccessResponse> updateComplaint(ComplaintDTO complaintDTO);

	ResponseEntity<ComplaintDTO> fetchComplaintDetails(long complaintId);

	ResponseEntity<SuccessResponse> deleteComplaint(long complaintId);
}
