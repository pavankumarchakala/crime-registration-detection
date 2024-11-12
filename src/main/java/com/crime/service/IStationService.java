package com.crime.service;

import org.springframework.http.ResponseEntity;

import com.crime.dto.StationDTO;
import com.crime.dto.SuccessResponse;

public interface IStationService {

	ResponseEntity<SuccessResponse> addStation(StationDTO stationDTO);

	ResponseEntity<SuccessResponse> updateStation(StationDTO stationDTO);

	ResponseEntity<StationDTO> fetchStationDetails(long stationId);

	ResponseEntity<SuccessResponse> deleteStation(long stationId);
}
