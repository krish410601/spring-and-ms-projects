package com.wipro.dms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.dms.dto.DoctorDTO;
import com.wipro.dms.entity.Doctor;
import com.wipro.dms.repository.DoctorRepository;

@Service
public class DoctorServiceImp implements IDoctorService{
	
	@Autowired
	DoctorRepository repo;
	
	@Override
	public Doctor getByDoctorid(int did) {
		return repo.findById(did).orElse(null);
		
	}
	@Override
	public Doctor addDoctor(DoctorDTO doc) {
		Doctor ent=new Doctor();
		ent.setDoctorName(doc.getDoctorName());
		ent.setSpecialization(doc.getSpecialization());
		ent.setExperience(doc.getExperience());
		ent.setPhoneNumber(doc.getPhoneNumber());
		ent.setEmail(doc.getEmail());
		ent.setAvailability(doc.getAvailability());

		return repo.save(ent);
	}
}
