package com.wipro.pat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wipro.pat.entity.Patient;


public interface PatientRepository extends JpaRepository<Patient,Integer>{

	

}

