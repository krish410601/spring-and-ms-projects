package com.wipro.pat.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PatientDTO {

	
	private int pId;
	private String patientName;
	private int age;
	
	private String gender;
	private Long phnNumber;
	private String Address;
	private String bloodGroup;
	
}
