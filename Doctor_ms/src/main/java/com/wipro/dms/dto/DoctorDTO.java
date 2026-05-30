package com.wipro.dms.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DoctorDTO {
	private int doctorId;
	private String doctorName;
	private String specialization;
	private int experience;
	private Long phoneNumber;
	private String email;
	private String availability;
}
