package com.wipro.doc.entity;

import lombok.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Doctor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int doctorId;
	private String doctorName;
	private String specialization;
	private int experience;
	private Long phoneNumber;
	private String email;
	private String availability;
	
}
