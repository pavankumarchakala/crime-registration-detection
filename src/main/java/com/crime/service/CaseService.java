package com.crime.service;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crime.dao.crimes.ICaseRepository;
import com.crime.dto.CaseeDTO;
import com.crime.dto.SuccessResponse;
import com.crime.entity.crimes.Casee;
import com.crime.exceptions.ApplicationException;
import com.crime.util.RandomUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CaseService implements ICaseService {

	private final ICaseRepository caseRepository;

	private final ModelMapper modelMapper;

	@Override
	@Transactional
	public ResponseEntity<SuccessResponse> addCase(CaseeDTO caseeDTO) {
		caseeDTO.setNumber(RandomUtils.getRandomString());
		Casee casee = modelMapper.map(caseeDTO, Casee.class);
		Casee savedCase = caseRepository.save(casee);
		return ResponseEntity.ok(SuccessResponse.builder().savedItemId(savedCase.getId()).status(HttpStatus.CREATED)
				.message("Case Created Successfully !!").build());
	}

	@Override
	@Transactional
	public ResponseEntity<SuccessResponse> updateCase(CaseeDTO caseeDTO) {
		Casee casee = caseRepository.findById(caseeDTO.getId()).orElseThrow(() -> ApplicationException.builder()
				.httpStatus(HttpStatus.NOT_FOUND).message("No Case found !!").build());
		modelMapper.map(caseeDTO, casee);
		return ResponseEntity.ok(SuccessResponse.builder().savedItemId(caseeDTO.getId()).status(HttpStatus.OK)
				.message("Case Updated Successfully !!").build());
	}

	@Override
	public ResponseEntity<CaseeDTO> fetchCaseDetails(long caseId) {
		Casee casee = caseRepository.findById(caseId).orElseThrow(() -> ApplicationException.builder()
				.httpStatus(HttpStatus.NOT_FOUND).message("No Case found !!").build());
		return ResponseEntity.ok(modelMapper.map(casee, CaseeDTO.class));
	}

	@Override
	@Transactional
	public ResponseEntity<SuccessResponse> deleteCase(long caseId) {
		caseRepository.deleteById(caseId);
		return ResponseEntity
				.ok(SuccessResponse.builder().status(HttpStatus.OK).message("Case Deleted Successfully !!").build());
	}

}
