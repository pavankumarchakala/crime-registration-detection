package com.crime.dao.crimes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crime.entity.crimes.Station;

@Repository
public interface IStationRepository extends JpaRepository<Station, Long> {

}
