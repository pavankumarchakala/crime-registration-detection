package com.crime.service;

import org.springframework.http.ResponseEntity;

import com.crime.dto.CaseeDTO;
import com.crime.dto.SuccessResponse;

public interface ICaseService {

	ResponseEntity<SuccessResponse> addCase(CaseeDTO caseeDTO);

	ResponseEntity<SuccessResponse> updateCase(CaseeDTO caseeDTO);

	ResponseEntity<CaseeDTO> fetchCaseDetails(long caseId);

	ResponseEntity<SuccessResponse> deleteCase(long caseId);

}
