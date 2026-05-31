package com.wipro.app.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AppointmentResponseDTO {
	private int appointmentId;
	private String appointmentDate;
	private String appointmentTime;
	private String status;
	private String reasonForVisit;
	private String message;
	private DoctorDTO doctor;
	private PatientDTO patient;
}

