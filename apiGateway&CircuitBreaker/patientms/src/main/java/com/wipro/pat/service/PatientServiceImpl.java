package com.wipro.pat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.pat.dto.PatientDTO;
import com.wipro.pat.entity.Patient;
import com.wipro.pat.repository.PatientRepository;
@Service
public class PatientServiceImpl implements IPatientService{
	@Autowired
	PatientRepository ptRepo;
	
	@Override
	public Patient addPatient(PatientDTO pt) {
		Patient ent=new Patient();
		ent.setPatientName(pt.getPatientName());
		ent.setAddress(pt.getAddress());
		ent.setAge(pt.getAge());
		ent.setGender(pt.getGender());
		ent.setPhnNumber(pt.getPhnNumber());
		ent.setBloodGroup(pt.getBloodGroup());
		return ptRepo.save(ent);
	}

	@Override
	public Patient getByPid(int pid) {
		return ptRepo.findById(pid).orElse(null);
	}
}

