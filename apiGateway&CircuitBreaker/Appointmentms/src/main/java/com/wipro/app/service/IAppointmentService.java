package com.wipro.app.service;

import java.util.List;

import com.wipro.app.dto.AppointmentDTO;
import com.wipro.app.dto.AppointmentResponseDTO;
import com.wipro.app.entity.Appointment;

public interface IAppointmentService {
	public  AppointmentResponseDTO  bookAppointment(AppointmentDTO apt);
	public  List<Appointment>    getAllAppointments();
	
}

