package com.wipro.pms.service;

import org.springframework.stereotype.Service;

import com.wipro.pms.dto.PatientDTO;
import com.wipro.pms.entity.Patient;

@Service
public interface IPatientService {
	public    Patient   getByPid(int pid);
	public  Patient  addPatient(PatientDTO pt);
}
