package com.wipro.pat.service;

import org.springframework.stereotype.Service;

import com.wipro.pat.dto.PatientDTO;
import com.wipro.pat.entity.Patient;

@Service
public interface IPatientService {
	public    Patient   getByPid(int pid);
	public  Patient  addPatient(PatientDTO pt);
}
