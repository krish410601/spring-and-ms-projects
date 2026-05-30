package com.wipro.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wipro.pms.entity.Patient;


public interface PatientRepository extends JpaRepository<Patient,Integer>{

	

}
