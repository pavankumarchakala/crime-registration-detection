package com.crime.dao.crimes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crime.entity.crimes.Complaint;

@Repository
public interface IComplaintRepository extends JpaRepository<Complaint, Long> {

}
