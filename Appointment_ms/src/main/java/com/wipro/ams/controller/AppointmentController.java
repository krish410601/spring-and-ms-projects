package com.wipro.ams.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.ams.dto.AppointmentDTO;
import com.wipro.ams.dto.AppointmentResponseDTO;
import com.wipro.ams.entity.Appointment;
import com.wipro.ams.service.IAppointmentService;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {
	
	@Autowired
	IAppointmentService service;
	
	
	@PostMapping("/bookAppointment")
	public  AppointmentResponseDTO  bookAppointment(@RequestBody AppointmentDTO apt) {
		return service.bookAppointment(apt);
		
	}
	@GetMapping("/getAllAppointmnets")
	public  List<Appointment>    getAllAppointments(){
		return service.getAllAppointments();
	}
}
