package com.wipro.ams.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AppointmentDTO {
	private int appointmentId;
	private String appointmentDate;
	private String appointmentTime;
	private String status;
	private String reasonForVisit;
	private int patientId;
	private int doctorId;
}
