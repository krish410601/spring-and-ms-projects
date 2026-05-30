package com.wipro.ams.service;

import java.util.List;

import com.wipro.ams.dto.AppointmentDTO;
import com.wipro.ams.dto.AppointmentResponseDTO;
import com.wipro.ams.entity.Appointment;

public interface IAppointmentService {
	public  AppointmentResponseDTO  bookAppointment(AppointmentDTO apt);
	public  List<Appointment>    getAllAppointments();
	
}
