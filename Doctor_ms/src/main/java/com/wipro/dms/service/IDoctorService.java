package com.wipro.dms.service;

import com.wipro.dms.dto.DoctorDTO;
import com.wipro.dms.entity.Doctor;

public interface IDoctorService {
	//public  Doctor  addDoctor(DoctorDTO emp);
	public    Doctor   getByDoctorid(int eid);
	public Doctor addDoctor(DoctorDTO doc);
}
