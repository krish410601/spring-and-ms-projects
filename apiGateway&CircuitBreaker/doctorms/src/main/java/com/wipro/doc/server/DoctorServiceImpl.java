package com.wipro.doc.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.doc.dto.DoctorDTO;
import com.wipro.doc.entity.Doctor;
import com.wipro.doc.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements IDoctorService{
	
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

