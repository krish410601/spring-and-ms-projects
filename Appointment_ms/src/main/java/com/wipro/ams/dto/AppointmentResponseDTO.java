package com.wipro.ams.dto;

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
	private DoctorDTO doctor;
	private PatientDTO patient;
}
