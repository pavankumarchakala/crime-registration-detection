package com.crime.dao.crimes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crime.entity.crimes.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Long> {

}
