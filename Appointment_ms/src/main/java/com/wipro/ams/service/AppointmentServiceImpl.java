package com.wipro.ams.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wipro.ams.dto.AppointmentDTO;
import com.wipro.ams.dto.AppointmentResponseDTO;
import com.wipro.ams.dto.DoctorDTO;
import com.wipro.ams.dto.PatientDTO;
import com.wipro.ams.entity.Appointment;
import com.wipro.ams.repository.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements IAppointmentService{
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	AppointmentRepository  aptRepo;
	
	@Override
	public AppointmentResponseDTO bookAppointment(AppointmentDTO dto) {
		String patientUrl="http://localhost:8082/api/patient/getPatient/"+dto.getPatientId();
		PatientDTO patient=restTemplate.getForObject(patientUrl,PatientDTO.class);
		if(patient==null) {
			throw new RuntimeException("Patient Not Found");
		}
		
		String doctorUrl="http://localhost:8081/api/doctors/getDoctor/"+dto.getDoctorId();
		DoctorDTO doctor=restTemplate.getForObject(doctorUrl,DoctorDTO.class);
		if(doctor==null) {
			throw new RuntimeException("Doctor Not Found");
		}
		
		Appointment apt=new Appointment();
		
		apt.setAppointmentDate(dto.getAppointmentDate());
		apt.setAppointmentTime(dto.getAppointmentTime());
		apt.setStatus(dto.getStatus());
		apt.setReasonForVisit(dto.getReasonForVisit());
		apt.setDoctorId(dto.getDoctorId());
		apt.setPatientId(dto.getPatientId());
		Appointment savedApt=aptRepo.save(apt);
		
		AppointmentResponseDTO response=new AppointmentResponseDTO();
		response.setAppointmentDate(savedApt.getAppointmentDate());
		response.setAppointmentTime(savedApt.getAppointmentTime());
		response.setStatus(savedApt.getStatus());
		response.setReasonForVisit(savedApt.getReasonForVisit());
		response.setDoctor(doctor);
		response.setPatient(patient);
		return response;
		
	}
	
	@Override
	public List<Appointment> getAllAppointments() {
		
		return aptRepo.findAll();
	}
}
