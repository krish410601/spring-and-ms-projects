package com.wipro.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wipro.app.dto.AppointmentDTO;
import com.wipro.app.dto.AppointmentResponseDTO;
import com.wipro.app.dto.DoctorDTO;
import com.wipro.app.dto.PatientDTO;
import com.wipro.app.entity.Appointment;
import com.wipro.app.repository.AppointmentRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class AppointmentServiceImpl implements IAppointmentService{
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	AppointmentRepository  aptRepo;
	
	@Override
	@CircuitBreaker(name="appointmentService",fallbackMethod="bookAppointmentFallback")
	public AppointmentResponseDTO bookAppointment(AppointmentDTO dto) {
		String patientUrl="http://PATIENT-SERVICE/api/patient/getPatient/"+dto.getPatientId();
		PatientDTO patient=restTemplate.getForObject(patientUrl,PatientDTO.class);
		if(patient==null) {
			throw new RuntimeException("Patient Not Found");
		}
		
		String doctorUrl="http://DOCTOR-SERVICE/api/doctors/getDoctor/"+dto.getDoctorId();
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

	public AppointmentResponseDTO bookAppointmentFallback(AppointmentDTO dto,Exception ex){
		AppointmentResponseDTO response=new AppointmentResponseDTO();
		response.setMessage("Patient/Doctor service is temporarily unavilable");
		return response;
	}
	
	@Override
	public List<Appointment> getAllAppointments() {
		
		return aptRepo.findAll();
	}
}

