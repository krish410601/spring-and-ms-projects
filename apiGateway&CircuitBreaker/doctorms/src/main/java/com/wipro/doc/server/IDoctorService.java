package com.wipro.doc.server;

import com.wipro.doc.dto.DoctorDTO;
import com.wipro.doc.entity.Doctor;

public interface IDoctorService {
	//public  Doctor  addDoctor(DoctorDTO emp);
	public    Doctor   getByDoctorid(int eid);
	public Doctor addDoctor(DoctorDTO doc);
}

