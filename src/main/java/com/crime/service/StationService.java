package com.crime.service;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crime.dao.crimes.IStationRepository;
import com.crime.dto.StationDTO;
import com.crime.dto.SuccessResponse;
import com.crime.entity.crimes.Station;
import com.crime.exceptions.ApplicationException;
import com.crime.util.RandomUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StationService implements IStationService {

	private final IStationRepository stationRepository;

	private final ModelMapper modelMapper;

	@Override
	@Transactional
	public ResponseEntity<SuccessResponse> addStation(StationDTO stationDTO) {
		stationDTO.setCode(RandomUtils.getRandomString());
		Station statione = modelMapper.map(stationDTO, Station.class);
		Station savedStation = stationRepository.save(statione);
		return ResponseEntity.ok(SuccessResponse.builder().savedItemId(savedStation.getId()).status(HttpStatus.CREATED)
				.message("Station Created Successfully !!").build());
	}

	@Override
	@Transactional
	public ResponseEntity<SuccessResponse> updateStation(StationDTO stationDTO) {
		Station statione = stationRepository.findById(stationDTO.getId()).orElseThrow(() -> ApplicationException
				.builder().httpStatus(HttpStatus.NOT_FOUND).message("No Station found !!").build());
		modelMapper.map(stationDTO, statione);
		return ResponseEntity.ok(SuccessResponse.builder().savedItemId(stationDTO.getId()).status(HttpStatus.OK)
				.message("Station Updated Successfully !!").build());
	}

	@Override
	public ResponseEntity<StationDTO> fetchStationDetails(long stationId) {
		Station statione = stationRepository.findById(stationId).orElseThrow(() -> ApplicationException.builder()
				.httpStatus(HttpStatus.NOT_FOUND).message("No Station found !!").build());
		return ResponseEntity.ok(modelMapper.map(statione, StationDTO.class));
	}

	@Override
	@Transactional
	public ResponseEntity<SuccessResponse> deleteStation(long stationId) {
		stationRepository.deleteById(stationId);
		return ResponseEntity
				.ok(SuccessResponse.builder().status(HttpStatus.OK).message("Station Deleted Successfully !!").build());
	}

}
