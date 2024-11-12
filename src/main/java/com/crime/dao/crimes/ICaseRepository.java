package com.crime.dao.crimes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crime.entity.crimes.Casee;

@Repository
public interface ICaseRepository extends JpaRepository<Casee, Long> {

}
